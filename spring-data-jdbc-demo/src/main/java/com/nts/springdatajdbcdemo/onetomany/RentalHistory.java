package com.nts.springdatajdbcdemo.onetomany;

import lombok.ToString;

import java.time.LocalDate;

@ToString
public class RentalHistory {
    private LocalDate rentalDate;

    public RentalHistory(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }
}
