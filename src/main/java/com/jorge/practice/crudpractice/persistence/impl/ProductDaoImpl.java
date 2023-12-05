package com.jorge.practice.crudpractice.persistence.impl;

import com.jorge.practice.crudpractice.entity.Product;
import com.jorge.practice.crudpractice.persistence.IProductDao;
import com.jorge.practice.crudpractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements IProductDao {
    private final ProductRepository productRepository;
    @Autowired
    public ProductDaoImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max) {
        return productRepository.findProductByPriceBetween(min, max);
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Product> update(Product product) {
        return Optional.empty();
    }
}
