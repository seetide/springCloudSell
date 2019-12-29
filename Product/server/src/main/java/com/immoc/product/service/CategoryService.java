package com.immoc.product.service;

import com.immoc.product.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
