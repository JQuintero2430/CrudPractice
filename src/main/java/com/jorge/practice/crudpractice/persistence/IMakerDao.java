package com.jorge.practice.crudpractice.persistence;

import com.jorge.practice.crudpractice.entity.Maker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
public interface IMakerDao {
    Optional<Maker> findById(Long id);
    List<Maker> findAll();
    Maker save(Maker maker);
    void deleteById(Long id);
    Optional<Maker> update(Maker maker);

}
