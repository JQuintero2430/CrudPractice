package com.jorge.practice.crudpractice.persistence.impl;

import com.jorge.practice.crudpractice.entity.Maker;
import com.jorge.practice.crudpractice.persistence.IMakerDao;
import com.jorge.practice.crudpractice.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class MakerDaoImpl implements IMakerDao {
    private final MakerRepository makerRepository;
    @Autowired
    public MakerDaoImpl(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return makerRepository.findAll();
    }

    @Override
    public Maker save(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }

    @Override
    public Optional<Maker> update(Maker maker) {
        return makerRepository.findById(maker.getId())
                .map(m -> {
                    m.setName(maker.getName());
                    return makerRepository.save(m);
                });
    }
}
