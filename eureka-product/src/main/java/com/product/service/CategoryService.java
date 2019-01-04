package com.product.service;

import com.product.pojo.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
}
