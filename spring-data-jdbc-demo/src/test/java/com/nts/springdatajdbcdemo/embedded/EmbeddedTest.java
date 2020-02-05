package com.nts.springdatajdbcdemo.embedded;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmbeddedTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployeeTest() {
        Employee entity = Employee.of(null, "test1", "test", new PhoneNumber("123", "비상"));
        employeeRepository.save(entity);

        employeeRepository.findAll().forEach(System.out::println);
    }
}
