package com.huythanh0x.springudemycouponserver.dto;

import com.huythanh0x.springudemycouponserver.model.CouponCourseData;
import com.huythanh0x.springudemycouponserver.utils.LastFetchTimeManager;

import java.util.List;

public class CouponResponseData {
    Long lastFetchTime;
    List<CouponCourseData> courses;

    public CouponResponseData(List<CouponCourseData> courses) {
        this.courses = courses;
        this.lastFetchTime = LastFetchTimeManager.loadLasFetchedTimeInMilliSecond();
    }

    public Long getLastFetchTime() {
        return lastFetchTime;
    }

    public List<CouponCourseData> getCourses() {
        return courses;
    }
}
