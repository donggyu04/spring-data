package com.nts.springdatajdbcdemo.onetomany;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.*;

@ToString
public class Movie {
    @Id
    private Long id;
    private String title;
    private String description;
    private Set<Rental> rentals;
    private List<RentalHistory> histories;
    private Map<String, Actor> cast;

    @PersistenceConstructor
    public Movie(Long id, String title, String description, Set<Rental> rentals, List<RentalHistory> histories, Map<String, Actor> cast) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rentals = rentals;
        this.histories = histories;
        this.cast = cast;
    }

    public Movie(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    static Movie of(Long id, String title, String description) {
        return new Movie(id, title, description, new HashSet<>(), new ArrayList<>(), new HashMap<>());
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public void addHistory(RentalHistory rentalHistory) {
        this.histories.add(rentalHistory);
    }

    public void addCast(String role, Actor actor) {
        this.cast.put(role, actor);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
