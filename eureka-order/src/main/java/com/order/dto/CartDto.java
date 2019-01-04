package com.order.dto;

import lombok.Data;

@Data
public class CartDto {
    private String productId;

    private int productQuantity;

    public CartDto(String productId, int productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
