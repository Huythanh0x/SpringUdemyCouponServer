package com.huythanh0x.springudemycouponserver.dto;

import com.huythanh0x.springudemycouponserver.model.coupon.CouponCourseData;
import com.huythanh0x.springudemycouponserver.utils.LastFetchTimeManager;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public class PagedCouponResponseDTO {
    LocalDateTime lastFetchTime;
    Long totalCoupon;
    Integer totalPage;
    Integer currentPage;
    List<CouponCourseData> courses;

    public PagedCouponResponseDTO(Page<CouponCourseData> courses) {
        this.totalPage = courses.getTotalPages();
        this.totalCoupon = courses.getTotalElements();
        this.currentPage = courses.getPageable().getPageNumber();
        this.courses = courses.getContent();
        this.lastFetchTime = LastFetchTimeManager.loadLasFetchedTimeInDateTimeString();
    }

    public Long getTotalCoupon() {
        return totalCoupon;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public LocalDateTime getLastFetchTime() {
        return lastFetchTime;
    }

    public List<CouponCourseData> getCourses() {
        return courses;
    }
}
