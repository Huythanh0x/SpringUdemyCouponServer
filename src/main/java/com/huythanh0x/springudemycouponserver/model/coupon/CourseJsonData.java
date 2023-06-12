package com.huythanh0x.springudemycouponserver.model.coupon;

public class CourseJsonData {
    private String category;
    private String subCategory;
    private String courseTitle;
    private String level;
    private String author;
    private int contentLength;
    private float rating;
    private int numberReviews;
    private int students;
    private String language;
    private String headline;
    private String description;

    public CourseJsonData(String category, String subCategory, String courseTitle, String level, String author, int contentLength, float rating, int numberReviews, int students, String language, String headline, String description) {
        this.category = category;
        this.subCategory = subCategory;
        this.courseTitle = courseTitle;
        this.level = level;
        this.author = author;
        this.contentLength = contentLength;
        this.rating = rating;
        this.numberReviews = numberReviews;
        this.students = students;
        this.language = language;
        this.headline = headline;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNumberReviews() {
        return numberReviews;
    }

    public void setNumberReviews(int numberReviews) {
        this.numberReviews = numberReviews;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}