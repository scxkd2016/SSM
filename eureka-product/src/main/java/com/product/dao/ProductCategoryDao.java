package com.product.dao;

import com.product.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDao extends JpaRepository<ProductCategory,String> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
}
