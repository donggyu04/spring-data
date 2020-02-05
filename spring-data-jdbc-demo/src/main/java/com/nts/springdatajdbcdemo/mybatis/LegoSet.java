package com.nts.springdatajdbcdemo.mybatis;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

@Data
public class LegoSet {
    private Map<String, Model> models = new HashMap<>();

    private @Id Integer id;
    private String name;
    private Manual manual;

    public void addModel(String name, String description) {
        Model model = new Model();
        model.name = name;
        model.description = description;
        models.put(name, model);
    }
}
