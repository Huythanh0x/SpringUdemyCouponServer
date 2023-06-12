package com.huythanh0x.springudemycouponserver.repository;

import com.huythanh0x.springudemycouponserver.model.log.LogAppData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogAppData, Integer> {
}
