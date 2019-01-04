package com.order.client;

import com.order.dto.CartDto;
import com.order.pojo.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("eureka-product")
public interface ProductClient {
    @GetMapping("/getmsg")
    String productMsg();

    @PostMapping("/product/list4order")
    List<ProductInfo> listForOrder(@RequestBody List<String> productList);

    @PostMapping("/product/decreasestock")
    void decreaseStock(@RequestBody List<CartDto> cartDtoList);
}
