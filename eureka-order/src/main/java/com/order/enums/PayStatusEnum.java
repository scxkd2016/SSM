package com.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCESS(1,"支付完成"),
    ;
    private int code;

    private String msg;

    PayStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
