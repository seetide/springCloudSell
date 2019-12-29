package com.immoc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by haitao on 12/22/19
 *
 * @project: product
 */

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<com.immoc.product.VO.ProductInfoVO> productInfoVOList;
}
