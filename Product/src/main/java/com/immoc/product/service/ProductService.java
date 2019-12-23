package com.immoc.product.service;

import com.immoc.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     * query all on shelf products to a list
     */

    List<ProductInfo> findUpAll();
}
