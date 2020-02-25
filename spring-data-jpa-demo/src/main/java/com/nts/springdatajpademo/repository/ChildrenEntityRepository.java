package com.nts.springdatajpademo.repository;

import com.nts.springdatajpademo.entity.ChildrenEntity;
import com.nts.springdatajpademo.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenEntityRepository extends JpaRepository<ChildrenEntity, Long> {
}
