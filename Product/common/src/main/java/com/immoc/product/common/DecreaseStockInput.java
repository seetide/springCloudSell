package com.immoc.product.common;

import lombok.Data;

/**
 * Created by haitao on 12/29/19
 *
 * @project: springCloudSell
 */

@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
