package com.huythanh0x.springudemycouponserver.controller;

import com.huythanh0x.springudemycouponserver.dto.CouponResponseData;
import com.huythanh0x.springudemycouponserver.model.CouponCourseData;
import com.huythanh0x.springudemycouponserver.service.CourseResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CouponResponseData getCoupons(@RequestParam(required = false, defaultValue = "100") String numberOfCoupon) {
        return courseResponseService.getCoupons(numberOfCoupon);
    }

    @PostMapping({"/", ""})
    @ResponseBody
    public CouponCourseData postNewCouponUrl(@RequestParam String couponUrl) {
        return courseResponseService.saveNewCouponUrl(couponUrl);
    }

    @DeleteMapping({"/", ""})
    @ResponseBody
    public void deleteCoupon(@RequestParam String couponUrl) {
        courseResponseService.deleteCoupon(couponUrl);
    }


    @PutMapping({"/", ""})
    @ResponseBody
    public void updateCoupon(@RequestParam String couponId) {
//        TODO implement later
    }

    @GetMapping("/filter")
    public CouponResponseData filterCoupons(@RequestParam(defaultValue = "") String category, @RequestParam(defaultValue = "-1") String rating, @RequestParam(defaultValue = "-1") String contentLength, @RequestParam(defaultValue = "") String level) {
        return courseResponseService.filterCoupons(rating, contentLength, level, category);
    }


    @GetMapping("/search")
    public CouponResponseData searchCoupons(@RequestParam String querySearch) {
        return courseResponseService.searchCoupons(querySearch);
    }
}
