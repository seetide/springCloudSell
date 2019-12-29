package com.immoc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */
@Data
@Entity
public class OrderMaster {

    @Id
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
}
