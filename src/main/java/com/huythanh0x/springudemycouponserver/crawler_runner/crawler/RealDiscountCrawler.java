package com.huythanh0x.springudemycouponserver.crawler_runner.crawler;

import com.huythanh0x.springudemycouponserver.crawler_runner.base.CouponUrlCrawlerBase;
import com.huythanh0x.springudemycouponserver.crawler_runner.fetcher.WebContentFetcher;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class RealDiscountCrawler extends CouponUrlCrawlerBase {
    @Value("${custom.number-of-real-discount-coupon}")
    int maxCouponRequest;
    String apiUrl = String.format("https://www.real.discount/api-web/all-courses/?store=Udemy&page=1&per_page=%s&orderby=undefined&free=0&search=&language=&cat=", maxCouponRequest);

    @Override
    public List<String> getAllCouponUrls() {
        var jsonArray = fetchListJsonFromAPI(apiUrl);
        List<String> allUrls = new ArrayList<>();
        for (var jo : jsonArray) {
            JSONObject jsonObject = (JSONObject) jo;
            allUrls.add(extractCouponUrl(jsonObject));
        }
        return allUrls;
    }

    String extractCouponUrl(JSONObject jsonObject) {
        return jsonObject.getString("url").replace("http://click.linksynergy.com/fs-bin/click?id=bnwWbXPyqPU&subid=&offerid=323058.1&type=10&tmpid=14537&RD_PARM1=", "");
    }

    public JSONArray fetchListJsonFromAPI(String apiUrl) {
        return new JSONArray(WebContentFetcher.getJsonObjectFrom(apiUrl).getJSONArray("results"));
    }
}
