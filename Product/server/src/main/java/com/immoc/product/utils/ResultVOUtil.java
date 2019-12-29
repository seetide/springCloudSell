package com.immoc.product.utils;

import com.immoc.product.VO.ResultVO;

/**
 * Created by haitao on 12/22/19
 *
 * @project: product
 */

public class ResultVOUtil {

    public static com.immoc.product.VO.ResultVO success(Object object) {

        com.immoc.product.VO.ResultVO resultVO = new com.immoc.product.VO.ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("Success");

        return resultVO;
    }
}
