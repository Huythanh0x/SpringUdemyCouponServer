package com.huythanh0x.springudemycouponserver.model;

import jakarta.persistence.Entity;

public class CouponJsonData {
    private Float price;
    private String expiredDate;
    private String previewImage;
    private String previewVideo;
    private int usesRemaining;

    public CouponJsonData(Float price, String expiredDate, String previewImage, String previewVideo, int usesRemaining) {
        this.price = price;
        this.expiredDate = expiredDate;
        this.previewImage = previewImage;
        this.previewVideo = previewVideo;
        this.usesRemaining = usesRemaining;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public String getPreviewVideo() {
        return previewVideo;
    }

    public void setPreviewVideo(String previewVideo) {
        this.previewVideo = previewVideo;
    }

    public int getUsesRemaining() {
        return usesRemaining;
    }

    public void setUsesRemaining(int usesRemaining) {
        this.usesRemaining = usesRemaining;
    }
}
