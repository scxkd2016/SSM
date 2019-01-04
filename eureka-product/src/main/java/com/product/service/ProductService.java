package com.product.service;

import com.product.dto.CartDto;
import com.product.pojo.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<CartDto> cartDtoList);
}
