package com.huythanh0x.springudemycouponserver.repository;

import com.huythanh0x.springudemycouponserver.model.coupon.ExpiredCourseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpiredCouponRepository extends JpaRepository<ExpiredCourseData, Integer> {
}
