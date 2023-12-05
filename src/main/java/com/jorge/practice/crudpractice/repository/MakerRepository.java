package com.jorge.practice.crudpractice.repository;

import com.jorge.practice.crudpractice.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long> {
}
