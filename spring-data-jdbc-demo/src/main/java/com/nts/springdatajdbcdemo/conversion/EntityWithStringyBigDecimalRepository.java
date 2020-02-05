package com.nts.springdatajdbcdemo.conversion;

import org.springframework.data.repository.CrudRepository;

public interface EntityWithStringyBigDecimalRepository extends CrudRepository<EntityWithStringyBigDecimal, Long> {
}
