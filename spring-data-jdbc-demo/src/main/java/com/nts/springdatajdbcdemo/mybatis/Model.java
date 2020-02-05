package com.nts.springdatajdbcdemo.mybatis;

import lombok.ToString;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;

@ToString
public class Model implements Persistable<String> {
    String name, description;

    @Nullable
    @Override
    public String getId() {
        return name;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
