package com.jorge.practice.crudpractice.service.impl;

import com.jorge.practice.crudpractice.entity.Product;
import com.jorge.practice.crudpractice.persistence.IProductDao;
import com.jorge.practice.crudpractice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final IProductDao productDao;
    @Autowired
    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max) {
        return productDao.findProductByPriceBetween(min, max);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    @Override
    public Optional<Product> update(Product product) {
        return productDao.findById(product.getId())
                .map(p -> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    p.setMaker(product.getMaker());
                    return productDao.save(p);
                });
    }
}
