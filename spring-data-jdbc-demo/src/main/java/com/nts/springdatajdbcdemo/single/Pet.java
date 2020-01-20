package com.nts.springdatajdbcdemo.single;

import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

//@Table("pets")
@ToString
public class Pet { // table "pet" 카멜 표기함
    @Id
    private Long id;
    private String name;
    //@Column("date_of_birth")
    private LocalDate birthDate; // column "birth_date"

    public Pet(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static Pet of(Long id, String name, LocalDate birthday) {
        return new Pet(id, name, birthday);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
