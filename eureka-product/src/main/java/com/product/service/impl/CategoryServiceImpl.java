package com.product.service.impl;

import com.product.dao.ProductCategoryDao;
import com.product.pojo.ProductCategory;
import com.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> list) {
        return productCategoryDao.findByCategoryTypeIn(list);
    }
}
