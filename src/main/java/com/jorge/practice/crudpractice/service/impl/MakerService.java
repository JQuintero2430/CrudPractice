package com.jorge.practice.crudpractice.service.impl;

import com.jorge.practice.crudpractice.entity.Maker;
import com.jorge.practice.crudpractice.persistence.IMakerDao;
import com.jorge.practice.crudpractice.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerService implements IMakerService {
    private final IMakerDao makerDao;
    @Autowired
    public MakerService(IMakerDao makerDao) {
        this.makerDao = makerDao;
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDao.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return makerDao.findAll();
    }

    @Override
    public void save(Maker maker) {
        makerDao.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDao.deleteById(id);
    }

    @Override
    public Optional<Maker> update(Maker maker) {
        return makerDao.findById(maker.getId())
                .map(m -> {
                    m.setName(maker.getName());
                    return makerDao.save(m);
                });
    }
}
