package com.product.service.impl;

import com.product.dao.ProductInfoDao;
import com.product.dto.CartDto;
import com.product.enums.ProductStatus;
import com.product.enums.ResultEnum;
import com.product.exception.ProductException;
import com.product.pojo.ProductInfo;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatus.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoDao.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto:cartDtoList) {
            Optional<ProductInfo> productInfoOptional = productInfoDao.findById(cartDto.getProductId());
            //商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            //库存是否足够
            int result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.STACK_EMPTY);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }
}
