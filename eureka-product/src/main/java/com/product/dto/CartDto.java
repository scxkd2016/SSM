package com.product.dto;

import lombok.Data;

@Data
public class CartDto {
    private String productId;

    private int productQuantity;
}
