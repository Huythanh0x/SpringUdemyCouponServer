package com.huythanh0x.springudemycouponserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class ExpiredCourseData {
    @Id
    String couponUrl;
    Timestamp timeStamp;

    public ExpiredCourseData() {

    }

    public ExpiredCourseData(String couponUrl) {
        this.couponUrl = couponUrl;
    }

    public String getCouponUrl() {
        return couponUrl;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}
