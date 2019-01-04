package com.product.controller;

import com.product.VO.ProductInfoVO;
import com.product.VO.ProductVO;
import com.product.VO.ResultVO;
import com.product.dto.CartDto;
import com.product.pojo.ProductCategory;
import com.product.pojo.ProductInfo;
import com.product.service.CategoryService;
import com.product.service.ProductService;
import com.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> productCategoryList =  categoryService.findByCategoryTypeIn(categoryList);
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.sucess(productVOList);
    }

    @PostMapping ("/list4order")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productList) {
        return productService.findList(productList);
    }

    @PostMapping("/decreasestock")
    public void decreaseStock(@RequestBody List<CartDto> cartDtoList) {
        productService.decreaseStock(cartDtoList);
    }


}
