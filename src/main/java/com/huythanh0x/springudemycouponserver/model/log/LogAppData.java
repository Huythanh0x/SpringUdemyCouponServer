package com.huythanh0x.springudemycouponserver.model.log;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class LogAppData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    LogCategory category;
    String owner;

    String tag;

    @CreationTimestamp
    private Timestamp createdDate;

    String content;

    public LogAppData(LogCategory category, String owner, String tag, String content) {
        this.category = category;
        this.owner = owner;
        this.tag = tag;
        this.content = content;
    }

    public LogAppData() {

    }

    public LogCategory getCategory() {
        return category;
    }

    public String getOwner() {
        return owner;
    }

    public String getTag() {
        return tag;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

