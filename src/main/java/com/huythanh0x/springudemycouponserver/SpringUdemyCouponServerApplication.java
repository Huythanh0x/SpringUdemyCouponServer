package com.huythanh0x.springudemycouponserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.huythanh0x.springudemycouponserver.crawler_runner", "com.huythanh0x.springudemycouponserver.service", "com.huythanh0x.springudemycouponserver.controller"})
public class SpringUdemyCouponServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUdemyCouponServerApplication.class, args);
    }

}