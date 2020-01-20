package com.nts.springdatajdbcdemo.onetoone;

import lombok.ToString;

@ToString
public class Address {
    private String city;
    private String street;
    private String zipCode;

    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    static Address of(String city, String street, String zipCode) {
        return new Address(city, street, zipCode);
    }
}
