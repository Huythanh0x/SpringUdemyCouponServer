package com.huythanh0x.springudemycouponserver.service;

import com.huythanh0x.springudemycouponserver.crawler_runner.UdemyCouponCourseExtractor;
import com.huythanh0x.springudemycouponserver.model.CouponCourseData;
import com.huythanh0x.springudemycouponserver.repository.CouponCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseResponseService {
    private final CouponCourseRepository couponCourseRepository;

    @Autowired
    public CourseResponseService(CouponCourseRepository couponCourseRepository) {
        this.couponCourseRepository = couponCourseRepository;
    }

    public List<CouponCourseData> getAllCoupons() {
        return couponCourseRepository.findAll();
    }

    public List<CouponCourseData> getNCoupons(Integer numberOfCoupon) {
        List<CouponCourseData> allCouponCourses = couponCourseRepository.findAll();
        if (numberOfCoupon < allCouponCourses.size()) {
            return allCouponCourses.subList(0, numberOfCoupon);
        } else {
            return allCouponCourses;
        }
    }

    public List<CouponCourseData> filterCoupons(String rating, String contentLength, String level, String category) {
        return couponCourseRepository.findAll().stream().filter(coupon -> coupon.getCategory().contains(category) && coupon.getLevel().contains(level) && coupon.getContentLength() > Float.parseFloat(contentLength) && coupon.getRating() > Float.parseFloat(rating)).collect(Collectors.toList());
    }

    public List<CouponCourseData> searchCoupons(String querySearch) {
        return couponCourseRepository.findByTitleContainingOrDescriptionContainingOrHeadingContaining(querySearch, querySearch, querySearch);
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
