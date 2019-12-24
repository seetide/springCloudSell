package com.immoc.order.utils;

import com.immoc.order.VO.ResultVO;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(0);
        resultVO.setMsg("Success");
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO failure(){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(1);
        resultVO.setMsg("Failure");
        //resultVO.setData(null);

        return resultVO;
    }
}
