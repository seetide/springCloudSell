package com.immoc.order.enums;

import lombok.Getter;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "Argument error"),
    CART_EMPTY(2, "shopping cart is empty"),
        ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
