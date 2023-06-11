drop table expired_course_data;
drop table coupon_course_data;

CREATE TABLE coupon_course_data
(
    course_id      INT PRIMARY KEY,
    category       VARCHAR(255),
    sub_category   VARCHAR(255),
    title          VARCHAR(255),
    content_length INT,
    level          VARCHAR(255),
    author         VARCHAR(255),
    rating         FLOAT,
    reviews        INT,
    students       INT,
    coupon_code    VARCHAR(255),
    preview_image  VARCHAR(255),
    coupon_url     VARCHAR(255),
    expired_date   VARCHAR(255),
    uses_remaining INT,
    heading        VARCHAR(255),
    description    TEXT,
    preview_video  VARCHAR(255),
    language       VARCHAR(255)
);

CREATE TABLE expired_course_data
(
    coupon_url VARCHAR(255) PRIMARY KEY,
    time_stamp TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);

show tables;

select course_id, title from coupon_course_data;
select coupon_url from expired_course_data;