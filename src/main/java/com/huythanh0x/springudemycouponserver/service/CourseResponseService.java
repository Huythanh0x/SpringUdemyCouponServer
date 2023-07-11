package com.huythanh0x.springudemycouponserver.service;

import com.huythanh0x.springudemycouponserver.crawler_runner.UdemyCouponCourseExtractor;
import com.huythanh0x.springudemycouponserver.dto.PagedCouponResponseDTO;
import com.huythanh0x.springudemycouponserver.exception.BadRequestException;
import com.huythanh0x.springudemycouponserver.model.coupon.CouponCourseData;
import com.huythanh0x.springudemycouponserver.model.log.LogAppData;
import com.huythanh0x.springudemycouponserver.model.log.LogCategory;
import com.huythanh0x.springudemycouponserver.repository.CouponCourseRepository;
import com.huythanh0x.springudemycouponserver.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseResponseService {
    private final CouponCourseRepository couponCourseRepository;
    LogRepository logRepository;


    @Autowired
    public CourseResponseService(CouponCourseRepository couponCourseRepository, LogRepository logRepository) {
        this.couponCourseRepository = couponCourseRepository;
        this.logRepository = logRepository;
    }

    public PagedCouponResponseDTO getPagedCoupons(String pageIndex, String numberPerPage, String remoteAddr) {
        handlePagingParameters(pageIndex, numberPerPage);
        Pageable pageable = PageRequest.of(Integer.parseInt(pageIndex), Integer.parseInt(numberPerPage));
        Page<CouponCourseData> allCouponCourses = couponCourseRepository.findAll(pageable);
        logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "getCoupons %s: ", String.format("requested: %s coupons, responded %s", pageIndex, numberPerPage)));
        return new PagedCouponResponseDTO(allCouponCourses);
    }

    public PagedCouponResponseDTO filterCoupons(String rating, String contentLength, String level, String category, String language, String pageIndex, String numberPerPage, String remoteAddr) {
        handlePagingParameters(pageIndex, numberPerPage);
        Pageable pageable = PageRequest.of(Integer.parseInt(pageIndex), Integer.parseInt(numberPerPage));
        Page<CouponCourseData> filterCouponCourses = couponCourseRepository.findByRatingGreaterThanAndContentLengthGreaterThanAndLevelContainingAndCategoryIsContainingIgnoreCaseAndLanguageContaining(Float.parseFloat(rating), Integer.parseInt(contentLength), level, category, language, pageable);
        logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "filterCoupons", String.format("%s %s %s %s %s: responded %s coupons", rating, contentLength, level, category, language, filterCouponCourses.getTotalElements())));
        return new PagedCouponResponseDTO(filterCouponCourses);
    }

    public PagedCouponResponseDTO searchCoupons(String querySearch, String pageIndex, String numberPerPage, String remoteAddr) {
        handlePagingParameters(pageIndex, numberPerPage);
        Pageable pageable = PageRequest.of(Integer.parseInt(pageIndex), Integer.parseInt(numberPerPage));
        Page<CouponCourseData> searchedCouponCourses = couponCourseRepository.findByTitleContainingOrDescriptionContainingOrHeadingContaining(querySearch, querySearch, querySearch, pageable);
        logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "searchCoupons", String.format("%s responded %s coupons", querySearch, searchedCouponCourses.getTotalElements())));
        return new PagedCouponResponseDTO(searchedCouponCourses);
    }

    public CouponCourseData saveNewCouponUrl(String couponUrl, String remoteAddr) {
        logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "saveNewCouponUrl", couponUrl));
        return couponCourseRepository.save(new UdemyCouponCourseExtractor(couponUrl).getFullCouponCodeData());
    }

    public void deleteCoupon(String couponUrl, String remoteAddr) {
        if (new UdemyCouponCourseExtractor(couponUrl).getFullCouponCodeData() == null) {
            logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "deleteCoupon", couponUrl));
            couponCourseRepository.deleteByCouponUrl(couponUrl);
        }
    }

    public void handlePagingParameters(String pageIndex, String numberPerPage) {
        try {
            Integer.parseInt(pageIndex);
            Integer.parseInt(numberPerPage);
        } catch (Exception e) {
            throw new BadRequestException(e.toString());
        }
        if (Integer.parseInt(pageIndex) < 0 || Integer.parseInt(numberPerPage) < 0) {
            throw new BadRequestException("Page index and number of course per page cannot be negative");
        }
    }
}
