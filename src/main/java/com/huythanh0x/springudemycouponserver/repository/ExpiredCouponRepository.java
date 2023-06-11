package com.huythanh0x.springudemycouponserver.repository;

import com.huythanh0x.springudemycouponserver.model.ExpiredCourseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpiredCouponRepository extends JpaRepository<ExpiredCourseData, Integer> {
}
