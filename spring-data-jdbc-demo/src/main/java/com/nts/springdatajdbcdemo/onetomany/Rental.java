package com.nts.springdatajdbcdemo.onetomany;

import lombok.ToString;

import java.time.Duration;

@ToString
public class Rental {
    private Duration duration;
    private Integer price;

    public Rental(Duration duration, Integer price) {
        this.duration = duration;
        this.price = price;
    }

    static Rental of(Duration duration, Integer price) {
        return new Rental(duration, price);
    }
}
