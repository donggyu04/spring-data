package com.nts.springdatajpademo.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;

@MappedSuperclass
public abstract class AbstractEntity<ID> implements Persistable<ID> {

    @Transient
    private boolean isNew = true;     // new instance를 나타낼 flag

    @Override
    public boolean isNew() {          // Persistable를 구현한 방식
        return isNew;
    }

    @PrePersist                       // lifecycle callback을 이용해서 flag를 토글
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }
}
