package com.nts.springdatajdbcdemo.onetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void testOneToMany() {
        Movie movie = Movie.of(null, "joker", "joker");

        System.out.println("============test 1==================");
        movie.addRental(Rental.of(Duration.ofDays(1), 2000));
        movie.addRental(Rental.of(Duration.ofDays(7), 10000));

        movieRepository.save(movie);
        movieRepository.findAll().forEach(System.out::println);

        System.out.println("============test 2==================");
        movie.setDescription("joker is crazy");
        movieRepository.save(movie);

        System.out.println("============test 3==================");
        LocalDate rentalHistory = LocalDate.now();
        movie.addHistory(new RentalHistory(rentalHistory));
        movie.addHistory(new RentalHistory(rentalHistory.minusDays(1)));
        movieRepository.save(movie);
        movieRepository.findAll().forEach(System.out::println);

        System.out.println("============test 4==================");
        movie.addCast("joker", new Actor("Joaquin Phoenix"));
        movie.addCast("person1", new Actor("taeyeon kim"));
        movieRepository.save(movie);
        movieRepository.findAll().forEach(System.out::println);
    }
}