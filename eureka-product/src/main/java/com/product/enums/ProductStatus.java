package com.product.enums;


public enum ProductStatus {
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;
    private int code;
    private String msg;

    ProductStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
