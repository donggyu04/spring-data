package com.nts.springdatajdbcdemo.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MybatisTest {

    @Autowired
    LegoSetRepository repository;

    @Test
    public void exerciseSomewhatComplexEntity() {
        LegoSet smallCar = createLegoSet();

        smallCar.setManual(new Manual("Just put all the pieces together in the right order", "Jens Schauder"));
        smallCar.addModel("suv", "SUV with sliding doors.");
        smallCar.addModel("roadster", "Slick red roadster.");

        repository.save(smallCar);

        assertThat(smallCar.getId()).isNotNull();
        assertThat(repository.findById(smallCar.getId()).get().getModels()).hasSize(2);

        System.out.println("Original LegoSet");
        repository.findAll().forEach(System.out::println);

        smallCar.getManual().setText("Just make it so it looks like a car.");
        smallCar.addModel("pickup", "A pickup truck with some tools in the back.");

        repository.save(smallCar);

        System.out.println("Original Updated");
        repository.findAll().forEach(System.out::println);

        smallCar.setManual(new Manual("One last attempt: Just build a car! Ok?", "Jens Schauder"));

        repository.save(smallCar);

        System.out.println("Manual replaced");
        repository.findAll().forEach(System.out::println);
    }

    private static LegoSet createLegoSet() {

        LegoSet smallCar = new LegoSet();
        smallCar.setName("Small Car 01");
        return smallCar;
    }

}
