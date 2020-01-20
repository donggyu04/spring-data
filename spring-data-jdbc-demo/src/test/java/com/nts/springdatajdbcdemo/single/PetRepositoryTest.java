package com.nts.springdatajdbcdemo.single;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;

    @Test
    void testSingle() {
        Pet pet = Pet.of(null, "cat", LocalDate.of(2019, 8, 6));

        System.out.println("============test 1==================");
        petRepository.save(pet);
        assertThat(petRepository.count()).isEqualTo(1);
        petRepository.findAll().forEach(System.out::println);

        System.out.println("============test 2==================");
        pet.setName("dog");
        petRepository.save(pet);
        assertThat(petRepository.count()).isEqualTo(1);
        petRepository.findAll().forEach(System.out::println);

        System.out.println("============test 3==================");
        pet.setName("cat");
        Pet pet1 = petRepository.save(pet);
        assertThat(pet.hashCode()).isEqualTo(pet1.hashCode());
        System.out.println(pet.hashCode());
        System.out.println(pet1.hashCode());

        System.out.println("============test 4==================");
        assertThat(petRepository.count()).isEqualTo(2);
    }
}