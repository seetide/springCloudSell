package com.immoc.order.enums;

import lombok.Getter;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

@Getter
public enum PayStatusEnum {
    WAIT(0, "Wait for payment"),
    SUCCESS(1, "Finished payment"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
