package com.huythanh0x.springudemycouponserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.json.JSONObject;

@Entity
public class CouponCourseData {
    @Id
    private int courseId;
    private String category;
    private String subCategory;
    private String title;
    private int contentLength;
    private String level;
    private String author;
    private float rating;
    private int reviews;
    private int students;
    private String couponCode;
    private String previewImage;
    private String couponUrl;
    private String expiredDate;
    private int usesRemaining;
    private String heading;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String previewVideo;
    private String language;

    public CouponCourseData(int courseId, String category, String subCategory, String title, int contentLength,
                            String level, String author, float rating, int reviews, int students, String couponCode,
                            String previewImage, String couponUrl, String expiredDate, int usesRemaining,
                            String heading, String description, String previewVideo, String language) {
        this.courseId = courseId;
        this.category = category;
        this.subCategory = subCategory;
        this.title = title;
        this.contentLength = contentLength;
        this.level = level;
        this.author = author;
        this.rating = rating;
        this.reviews = reviews;
        this.students = students;
        this.couponCode = couponCode;
        this.previewImage = previewImage;
        this.couponUrl = couponUrl;
        this.expiredDate = expiredDate;
        this.usesRemaining = usesRemaining;
        this.heading = heading;
        this.description = description;
        this.previewVideo = previewVideo;
        this.language = language;
    }

    public CouponCourseData() {

    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("courseId", courseId);
        json.put("category", category);
        json.put("subCategory", subCategory);
        json.put("title", title);
        json.put("contentLength", contentLength);
        json.put("level", level);
        json.put("author", author);
        json.put("rating", rating);
        json.put("reviews", reviews);
        json.put("students", students);
        json.put("couponCode", couponCode);
        json.put("previewImage", previewImage);
        json.put("couponUrl", couponUrl);
        json.put("expiredDate", expiredDate);
        json.put("usesRemaining", usesRemaining);
        json.put("heading", heading);
        json.put("description", description);
        json.put("previewVideo", previewVideo);
        json.put("language", language);
        return json;
    }

    public String toCSVString() {
        return courseId + "|||" + category + "|||" + subCategory + "|||" + title + "|||" + contentLength + "|||" +
                level + "|||" + author + "|||" + rating + "|||" + reviews + "|||" + students + "|||" +
                couponCode + "|||" + previewImage + "|||" + couponUrl + "|||" + expiredDate + "|||" +
                usesRemaining + "|||" + heading + "|||" + description + "|||" + previewVideo + "|||" + language + "\n";
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public int getContentLength() {
        return contentLength;
    }

    public String getLevel() {
        return level;
    }

    public String getAuthor() {
        return author;
    }

    public float getRating() {
        return rating;
    }

    public int getReviews() {
        return reviews;
    }

    public int getStudents() {
        return students;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public String getCouponUrl() {
        return couponUrl;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public int getUsesRemaining() {
        return usesRemaining;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getPreviewVideo() {
        return previewVideo;
    }

    public String getLanguage() {
        return language;
    }
}
