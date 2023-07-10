drop table if exists expired_course_data;
drop table if exists coupon_course_data;
drop table if exists log_app_data;


drop table if exists users_roles;
drop table if exists users;
drop table if exists roles;

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

CREATE TABLE log_app_data
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    category     ENUM ('EXCEPTION', 'REQUEST', 'RUNNER') NOT NULL,
    owner        VARCHAR(255)                            NOT NULL,
    tag          VARCHAR(255)                            NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    content      TEXT
);

CREATE TABLE roles
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles
(
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles(id, name)
VALUES (1, "USER");

INSERT INTO roles(id, name)
VALUES (2, "ADMIN");

show
    tables;

select course_id, title
from coupon_course_data;

select *
from expired_course_data;

select *
from log_app_data;