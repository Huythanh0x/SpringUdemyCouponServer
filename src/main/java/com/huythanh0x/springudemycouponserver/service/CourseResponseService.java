package com.huythanh0x.springudemycouponserver.service;

import com.huythanh0x.springudemycouponserver.crawler_runner.UdemyCouponCourseExtractor;
import com.huythanh0x.springudemycouponserver.dto.CouponResponseData;
import com.huythanh0x.springudemycouponserver.model.CouponCourseData;
import com.huythanh0x.springudemycouponserver.repository.CouponCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseResponseService {
    private final CouponCourseRepository couponCourseRepository;

    @Autowired
    public CourseResponseService(CouponCourseRepository couponCourseRepository) {
        this.couponCourseRepository = couponCourseRepository;
    }

    public CouponResponseData getCoupons(String numberOfCoupon) {
        List<CouponCourseData> allCouponCourses = couponCourseRepository.findAll();
        if (Integer.parseInt(numberOfCoupon) < allCouponCourses.size()) {
            return new CouponResponseData(allCouponCourses.subList(0, Integer.parseInt(numberOfCoupon)));
        } else {
            return new CouponResponseData(allCouponCourses);
        }
    }

    public CouponResponseData filterCoupons(String rating, String contentLength, String level, String category) {
        List<CouponCourseData> filterCouponCourses = couponCourseRepository.findAll().stream().filter(coupon -> coupon.getCategory().contains(category) && coupon.getLevel().contains(level) && coupon.getContentLength() > Float.parseFloat(contentLength) && coupon.getRating() > Float.parseFloat(rating)).collect(Collectors.toList());
        return new CouponResponseData(filterCouponCourses);
    }

    public CouponResponseData searchCoupons(String querySearch) {
        List<CouponCourseData> searchedCouponCourses = couponCourseRepository.findByTitleContainingOrDescriptionContainingOrHeadingContaining(querySearch, querySearch, querySearch);
        return new CouponResponseData(searchedCouponCourses);
    }

    public CouponCourseData saveNewCouponUrl(String couponUrl) {
        return couponCourseRepository.save(new UdemyCouponCourseExtractor(couponUrl).getFullCouponCodeData());
    }

    public void deleteCoupon(String couponUrl) {
        if (new UdemyCouponCourseExtractor(couponUrl).getFullCouponCodeData() == null) {
            couponCourseRepository.deleteByCouponUrl(couponUrl);
        }
    }
}
