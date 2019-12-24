package com.immoc.order.exception;

import com.immoc.order.enums.ResultEnum;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
