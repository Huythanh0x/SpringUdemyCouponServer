package com.huythanh0x.springudemycouponserver.controller;

import com.huythanh0x.springudemycouponserver.dto.CouponResponseData;
import com.huythanh0x.springudemycouponserver.model.coupon.CouponCourseData;
import com.huythanh0x.springudemycouponserver.service.CourseResponseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/coupons")
public class CouponCourseController {
    CourseResponseService courseResponseService;

    @Autowired
    public CouponCourseController(CourseResponseService courseResponseService) {
        this.courseResponseService = courseResponseService;
    }

    @GetMapping({"/", ""})
    @ResponseBody
    public CouponResponseData getCoupons(@RequestParam(required = false, defaultValue = "100") String numberOfCoupon, HttpServletRequest request) {
        return courseResponseService.getCoupons(numberOfCoupon, request.getRemoteAddr());
    }

    @PostMapping({"/", ""})
    @ResponseBody
    public CouponCourseData postNewCouponUrl(@RequestParam String couponUrl, HttpServletRequest request) {
        return courseResponseService.saveNewCouponUrl(couponUrl, request.getRemoteAddr());
    }

    @DeleteMapping({"/", ""})
    @ResponseBody
    public void deleteCoupon(@RequestParam String couponUrl, HttpServletRequest request) {
        courseResponseService.deleteCoupon(couponUrl, request.getRemoteAddr());
    }


    @PutMapping({"/", ""})
    @ResponseBody
    public void updateCoupon(@RequestParam String couponId) {
//        TODO implement later
    }

    @GetMapping("/filter")
    public CouponResponseData filterCoupons(@RequestParam(defaultValue = "") String category, @RequestParam(defaultValue = "-1") String rating, @RequestParam(defaultValue = "-1") String contentLength, @RequestParam(defaultValue = "") String level, @RequestParam(defaultValue = "") String language, HttpServletRequest request) {
        return courseResponseService.filterCoupons(rating, contentLength, level, category, language, request.getRemoteAddr());
    }


    @GetMapping("/search")
    public CouponResponseData searchCoupons(@RequestParam String querySearch, HttpServletRequest request) {
        return courseResponseService.searchCoupons(querySearch, request.getRemoteAddr());
    }
}
