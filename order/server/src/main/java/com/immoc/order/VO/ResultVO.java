package com.immoc.order.VO;

import lombok.Data;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
