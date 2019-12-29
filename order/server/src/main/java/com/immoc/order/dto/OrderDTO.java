package com.immoc.order.dto;

import com.immoc.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    /** buyer's wechat id */
    private String buyerOpenid;

    private BigDecimal orderAmount;

    /** default 0 new order */
    private Integer orderStatus;

    /** default 0 not pay */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
