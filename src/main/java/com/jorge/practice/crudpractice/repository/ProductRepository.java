package com.jorge.practice.crudpractice.repository;

import com.jorge.practice.crudpractice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
//    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
//
    List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max);
}
