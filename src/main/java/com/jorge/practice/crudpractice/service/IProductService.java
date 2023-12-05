package com.jorge.practice.crudpractice.service;

import com.jorge.practice.crudpractice.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max);
    Product save(Product product);
    void deleteById(Long id);
    Optional<Product> update(Product product);
}
