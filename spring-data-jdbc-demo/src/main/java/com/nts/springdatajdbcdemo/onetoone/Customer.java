package com.nts.springdatajdbcdemo.onetoone;

import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@ToString
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Address address;

    public Customer(Long id, String firstName, String lastName, LocalDate birthday, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
    }

    static Customer of(Long id, String firstName, String lastName, LocalDate birthday, Address address) {
        return new Customer(id, firstName, lastName, birthday, address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
