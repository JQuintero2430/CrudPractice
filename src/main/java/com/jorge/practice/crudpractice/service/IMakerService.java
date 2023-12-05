package com.jorge.practice.crudpractice.service;

import com.jorge.practice.crudpractice.entity.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {
    Optional<Maker> findById(Long id);
    List<Maker> findAll();
    Maker save(Maker maker);
    void deleteById(Long id);
    Optional<Maker> update(Maker maker);
}
