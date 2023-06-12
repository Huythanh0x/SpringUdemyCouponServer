package com.huythanh0x.springudemycouponserver.service;

import com.huythanh0x.springudemycouponserver.crawler_runner.UdemyCouponCourseExtractor;
import com.huythanh0x.springudemycouponserver.dto.CouponResponseData;
import com.huythanh0x.springudemycouponserver.model.coupon.CouponCourseData;
import com.huythanh0x.springudemycouponserver.model.log.LogCategory;
import com.huythanh0x.springudemycouponserver.model.log.LogAppData;
import com.huythanh0x.springudemycouponserver.repository.CouponCourseRepository;
import com.huythanh0x.springudemycouponserver.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseResponseService {
    private final CouponCourseRepository couponCourseRepository;
    LogRepository logRepository;


    @Autowired
    public CourseResponseService(CouponCourseRepository couponCourseRepository, LogRepository logRepository) {
        this.couponCourseRepository = couponCourseRepository;
        this.logRepository = logRepository;
    }

    public CouponResponseData getCoupons(String numberOfCoupon, String remoteAddr) {
        List<CouponCourseData> allCouponCourses = couponCourseRepository.findAll();
        if (Integer.parseInt(numberOfCoupon) < allCouponCourses.size()) {
            logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "getCoupons: ", String.format("requested: %s, responded %s", numberOfCoupon, numberOfCoupon)));
            return new CouponResponseData(allCouponCourses.subList(0, Integer.parseInt(numberOfCoupon)));
        } else {
            logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "getCoupons %s: ", String.format("requested: %s coupons, responded %s", numberOfCoupon, allCouponCourses.size())));
            return new CouponResponseData(allCouponCourses);
        }
    }

    public CouponResponseData filterCoupons(String rating, String contentLength, String level, String category, String language, String remoteAddr) {
        List<CouponCourseData> filterCouponCourses = couponCourseRepository.findByRatingGreaterThanAndContentLengthGreaterThanAndLevelContainingAndCategoryIsContainingIgnoreCaseAndLanguageContaining(Float.parseFloat(rating), Integer.parseInt(contentLength), level, category, language);
        logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "filterCoupons", String.format("%s %s %s %s %s: responded %s coupons", rating, contentLength, level, category, language, filterCouponCourses.size())));
        return new CouponResponseData(filterCouponCourses);
    }

    public CouponResponseData searchCoupons(String querySearch, String remoteAddr) {
        List<CouponCourseData> searchedCouponCourses = couponCourseRepository.findByTitleContainingOrDescriptionContainingOrHeadingContaining(querySearch, querySearch, querySearch);
        logRepository.save(new LogAppData(LogCategory.REQUEST, remoteAddr, "searchCoupons", String.format("%s responded %s coupons", querySearch, searchedCouponCourses.size())));
        return new CouponResponseData(searchedCouponCourses);
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
}
