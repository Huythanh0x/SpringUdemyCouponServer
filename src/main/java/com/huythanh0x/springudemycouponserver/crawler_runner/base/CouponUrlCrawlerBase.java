package com.huythanh0x.springudemycouponserver.crawler_runner.base;

import java.util.List;

public abstract class CouponUrlCrawlerBase {
    String apiUrl;

    public abstract List<String> getAllCouponUrls();
}
