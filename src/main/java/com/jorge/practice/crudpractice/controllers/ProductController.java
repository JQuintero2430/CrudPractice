package com.jorge.practice.crudpractice.controllers;

import com.jorge.practice.crudpractice.entity.Product;
import com.jorge.practice.crudpractice.entity.dto.ProductDto;
import com.jorge.practice.crudpractice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> findAll() {
        List<ProductDto> productDtoList = productService.findAll()
                .stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build()
                ).toList();
        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);

        if (product.isPresent()) {
            ProductDto productDto = ProductDto.builder()
                    .name(product.get().getName())
                    .price(product.get().getPrice())
                    .maker(product.get().getMaker())
                    .build();
            return ResponseEntity.ok(productDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) throws URISyntaxException {
        if (productDto.getName().isBlank() || productDto.getPrice() == null || productDto.getMaker() == null) {
            return ResponseEntity.badRequest().build();
        }
        productService.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .maker(productDto.getMaker())
                .build());
        return ResponseEntity.created(new URI("/v1/api/products/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setMaker(productDto.getMaker());
            productService.save(product);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find/price/between")
    public ResponseEntity<?> findProductByPriceBetween(@RequestParam("min") BigDecimal min, @RequestParam("max") BigDecimal max) {
        List<ProductDto> productDtoList = productService.findProductByPriceBetween(min, max)
                .stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build()
                ).toList();
        return ResponseEntity.ok(productDtoList);
    }
}
