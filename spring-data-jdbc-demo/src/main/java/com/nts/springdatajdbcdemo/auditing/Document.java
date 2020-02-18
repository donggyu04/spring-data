package com.nts.springdatajdbcdemo.auditing;

import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

@ToString
public class Document {
    @Id
    private Long id;

    @Setter
    private String description;

    @CreatedBy
    private String createdUser;
    @LastModifiedBy
    private String lastModifiedUser;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public Document(String description) {
        this.description = description;
    }
}
