package com.immoc.product.service.impl;

import com.immoc.product.ProductApplication;
import com.immoc.product.ProductApplicationTests;
import com.immoc.product.dataobject.ProductCategory;
import com.immoc.product.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class CategoryServiceimplTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));

        Assert.assertTrue(list.size() > 0);
    }

}