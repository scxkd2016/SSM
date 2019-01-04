package com.order.controller;

import com.order.client.ProductClient;
import com.order.dto.CartDto;
import com.order.pojo.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {
    @Autowired
    private ProductClient productClient;

    @GetMapping("/getMsgPro")
    public String getPro() {
        String response = productClient.productMsg();
        return response;
    }

    @GetMapping("/getProductList")
    public String getProList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("rep={}",productInfoList);
        return "OK";
    }

    @GetMapping("/decreasestock")
    public String decreasestock() {
        List<CartDto> cartDtoList = new ArrayList<>();
        cartDtoList.add(new CartDto("157875196366160022",2));
        //productClient.decreaseStock(Arrays.asList(new CartDto("157875196366160022",2)));
        productClient.decreaseStock(cartDtoList);
        return "OK";
    }
}
