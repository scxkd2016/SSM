package com.product.utils;

import com.product.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO sucess(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }
}
