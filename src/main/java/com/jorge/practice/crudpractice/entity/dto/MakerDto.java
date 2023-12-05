package com.jorge.practice.crudpractice.entity.dto;

import com.jorge.practice.crudpractice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakerDto {

    private Long id;
    private String name;
    private List<Product> products;
}
