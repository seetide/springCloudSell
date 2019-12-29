package com.immoc.product.VO;

import lombok.Data;

@Data
public class ResultVO<T> {

    /**
     * error code
     */
    private Integer code;
    /**
     * error message
     */
    private String msg;

    /**
     * detail content
     */
    private T data;
}
