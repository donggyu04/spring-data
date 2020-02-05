package com.nts.springdatajdbcdemo.embedded;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@ToString
@AllArgsConstructor
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @Embedded(onEmpty = USE_NULL)
    private PhoneNumber phoneNumber;

    public static Employee of(Long id, String firstName, String lastName, PhoneNumber phoneNumber) {
        return new Employee(id, firstName, lastName, phoneNumber);
    }
}
