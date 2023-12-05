package com.jorge.practice.crudpractice.persistence;

import com.jorge.practice.crudpractice.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
public interface IProductDao {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max);
    Product save(Product product);
    void deleteById(Long id);
    Optional<Product> update(Product product);

}
