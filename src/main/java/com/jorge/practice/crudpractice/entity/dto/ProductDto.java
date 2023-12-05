package com.jorge.practice.crudpractice.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jorge.practice.crudpractice.entity.Maker;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
