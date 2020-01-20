package com.nts.springdatajdbcdemo.onetomany;

import lombok.ToString;

@ToString
public class Actor {
    private String name;

    public Actor(String name) {
        this.name = name;
    }
}
