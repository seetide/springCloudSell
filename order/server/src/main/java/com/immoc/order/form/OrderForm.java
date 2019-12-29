package com.immoc.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */
@Data
public class OrderForm {

    @NotEmpty(message = "name must be filled")
    private String name;

    @NotEmpty(message = "phone number is required")
    private String phone;

    @NotEmpty(message = "address is required")
    private String address;

    @NotEmpty(message = "openid of wechat is required")
    private String openid;

    @NotEmpty(message = "cart can't be empty")
    private String items;
}
