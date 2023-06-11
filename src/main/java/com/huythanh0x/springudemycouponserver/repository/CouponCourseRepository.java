package com.huythanh0x.springudemycouponserver.repository;

import com.huythanh0x.springudemycouponserver.model.CouponCourseData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CouponCourseRepository extends JpaRepository<CouponCourseData, Integer> {
    List<CouponCourseData> findByTitleContainingOrDescriptionContainingOrHeadingContaining(String title, String description, String heading);

    @Modifying
    @Transactional
    @Query("DELETE FROM CouponCourseData ccd WHERE ccd.couponUrl IN :expiredCouponUrls")
    void deleteAllCouponsByUrl(Set<String> expiredCouponUrls);

    @Modifying
    @Transactional
    void deleteByCouponUrl(String couponUrl);
}
