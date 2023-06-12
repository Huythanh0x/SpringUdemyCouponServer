package com.huythanh0x.springudemycouponserver.model.coupon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class ExpiredCourseData {
    @Id
    String couponUrl;
    @CreationTimestamp
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
