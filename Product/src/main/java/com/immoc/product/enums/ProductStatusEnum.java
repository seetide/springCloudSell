package com.immoc.product.enums;

import lombok.Getter;

/**
 * product status of availability
 */

@Getter
public enum ProductStatusEnum {

    UP(0, "On self"),
    DOWN(1, "Unavailable"),

    ;

    private Integer code;
    private String message;


    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
