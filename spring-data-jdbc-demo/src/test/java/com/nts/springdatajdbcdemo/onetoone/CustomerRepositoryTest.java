package com.nts.springdatajdbcdemo.onetoone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testOneToOne() {
        Customer customer = Customer.of(
                null,
                "taeyeon",
                "kim",
                LocalDate.of(1991, 8, 6),
                null);

        System.out.println("============test 1==================");
        customerRepository.save(customer);
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("============test 2==================");
        Address address = Address.of("seoul", "jayang", "123123");
        customer.setAddress(address);
        customerRepository.save(customer);
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("============test 3==================");
        address = Address.of("seoul", "bundang", "345345");
        customer.setAddress(address);
        customerRepository.save(customer);
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("============test 4==================");
        customer.setAddress(null);
        customerRepository.save(customer);
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("============test 5==================");
        customer.setAddress(address);
        customerRepository.save(customer);
        customerRepository.delete(customer);
        assertThat(customerRepository.count()).isEqualTo(0);
    }
}