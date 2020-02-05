package com.nts.springdatajdbcdemo.conversion;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class EntityWithStringyBigDecimal {
    @Id
    private Long id;
    private String stringyNumber;
}

