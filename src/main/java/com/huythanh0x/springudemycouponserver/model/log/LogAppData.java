package com.huythanh0x.springudemycouponserver.model.log;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

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
}

