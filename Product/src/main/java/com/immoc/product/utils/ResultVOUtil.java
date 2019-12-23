package com.immoc.product.utils;

import com.immoc.product.VO.ResultVO;

/**
 * Created by haitao on 12/22/19
 *
 * @project: product
 */

public class ResultVOUtil {

    public static ResultVO success(Object object) {

        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("Success");

        return resultVO;
    }
}
