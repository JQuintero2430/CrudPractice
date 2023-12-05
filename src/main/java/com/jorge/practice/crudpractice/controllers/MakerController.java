package com.jorge.practice.crudpractice.controllers;

import com.jorge.practice.crudpractice.entity.Maker;
import com.jorge.practice.crudpractice.entity.dto.MakerDto;
import com.jorge.practice.crudpractice.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/makers")
public class MakerController {

    private final IMakerService makerService;

    @Autowired
    public MakerController(IMakerService makerService) {
        this.makerService = makerService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            MakerDto makerDto = MakerDto.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .products(maker.getProducts())
                    .build();
            return ResponseEntity.ok(makerDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> findAll() {
        List<MakerDto> makerDtoList = makerService.findAll()
                .stream()
                .map(maker -> MakerDto.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .products(maker.getProducts())
                        .build()
                ).toList();
        return ResponseEntity.ok(makerDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDto makerDto) throws URISyntaxException {
        if (makerDto.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        makerService.save(Maker.builder()
                .name(makerDto.getName())
                .build());
        return ResponseEntity.created(new URI("/v1/api/makers/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MakerDto makerDto) {
        Optional<Maker> makerOptional = makerService.findById(id);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerDto.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);
        if (makerOptional.isPresent()) {
            makerService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
