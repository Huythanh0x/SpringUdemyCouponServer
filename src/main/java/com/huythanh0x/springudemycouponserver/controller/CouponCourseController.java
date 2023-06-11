package com.huythanh0x.springudemycouponserver.controller;

import com.huythanh0x.springudemycouponserver.model.CouponCourseData;
import com.huythanh0x.springudemycouponserver.service.CourseResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coupons")
public class CouponCourseController {
    CourseResponseService courseResponseService;

    @Autowired
    public CouponCourseController(CourseResponseService courseResponseService) {
        this.courseResponseService = courseResponseService;
    }

    @GetMapping({"/all", "/", ""})
    @ResponseBody
    public List<CouponCourseData> getAll() {
        return courseResponseService.getAllCoupons();
    }

    @PostMapping({"/new"})
    @ResponseBody
    public CouponCourseData postNewCouponUrl(@RequestParam String couponUrl) {
        return courseResponseService.saveNewCouponUrl(couponUrl);
    }

    @DeleteMapping({"/report", "/delete"})
    @ResponseBody
    public void deleteCoupon(@RequestParam String couponUrl) {
        courseResponseService.deleteCoupon(couponUrl);
    }


    @PutMapping({"/update"})
    @ResponseBody
    public void updateCoupon(@RequestParam String couponId) {
//        TODO implement later
    }


    @GetMapping("/{numberOfCoupon}")
    @ResponseBody
    public List<CouponCourseData> getNCoupons(@PathVariable Integer numberOfCoupon) {
        return courseResponseService.getNCoupons(numberOfCoupon);
    }

    @GetMapping("/filter")
    public List<CouponCourseData> filterCoupons(@RequestParam(defaultValue = "") String category, @RequestParam(defaultValue = "-1") String rating, @RequestParam(defaultValue = "-1") String contentLength, @RequestParam(defaultValue = "") String level) {
        return courseResponseService.filterCoupons(rating, contentLength, level, category);
    }


    @GetMapping("/search")
    public List<CouponCourseData> searchCoupons(@RequestParam String querySearch) {
        return courseResponseService.searchCoupons(querySearch);
    }
}
