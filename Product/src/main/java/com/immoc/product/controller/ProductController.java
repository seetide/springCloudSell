package com.immoc.product.controller;

import com.immoc.product.VO.ProductInfoVO;
import com.immoc.product.VO.ProductVO;
import com.immoc.product.VO.ResultVO;
import com.immoc.product.dataobject.ProductCategory;
import com.immoc.product.dataobject.ProductInfo;
import com.immoc.product.service.CategoryService;
import com.immoc.product.service.ProductService;
import com.immoc.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. query all on shelf products
     * 2. get category type list
     * 3. query category
     * 4. create the data
     *
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        //1. query all on shelf products
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. get category type list
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        // 3. query category from database
        List<ProductCategory> catetoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 4. create the data

        List<ProductVO> productVOList = new ArrayList<>();

        for(ProductCategory productCategory : catetoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            for(ProductInfo productInfo : productInfoList) {

                if(productInfo.getCategoryType().equals(productCategory.getCategoryId())){
                    ProductInfoVO  productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);

        }


        return ResultVOUtil.success(productVOList);
    }
}
