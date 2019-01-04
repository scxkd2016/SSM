package com.product.dao;

import com.product.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String > {
     List<ProductInfo> findByProductStatus(Integer productStatus);

     List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
