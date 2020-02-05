package com.nts.springdatajdbcdemo.mybatis;

import lombok.Getter;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;

@Getter
public class ModelMapEntry implements Map.Entry<String, Model> {
    private final String key;
    private final Model value;

    ModelMapEntry(String name, Clob description) {
        key = name;
        value = new Model();
        value.name = name;

        try {
            value.description = description.getSubString(1, (int) description.length());
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    @Override
    public Model setValue(Model value) {
        throw new UnsupportedOperationException("can't set the value of a ModelMapEntry");
    }
}
