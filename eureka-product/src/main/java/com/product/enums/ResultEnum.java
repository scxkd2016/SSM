package com.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1, "参数错误"),
    STACK_EMPTY(2, "库粗不足")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
