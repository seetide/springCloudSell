package com.immoc.product.client;

import com.immoc.product.common.DecreaseStockInput;
import com.immoc.product.common.ProductInfoOutput;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haitao on 12/29/19
 *
 * @project: springCloudSell
 */

@Component
public class ProductClientFallback implements ProductClient {

    @Override
    public String productMsg() {
        return "服务降级";
    }

    @Override
    public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
        return null;
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> cartDTOList) {

    }
}