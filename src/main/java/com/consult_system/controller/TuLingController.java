package com.consult_system.controller;

import com.consult_system.util.TuLingApiUtil;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * author jacob
 */

@RestController
public class TuLingController {

    @RequestMapping(value = "/robot/request",method = RequestMethod.POST)
    public ApiResult robotRequest(String question){
        if (!StringUtils.isEmpty(question)){
            return ApiResult.ok(TuLingApiUtil.getMessage(question));
        }else {
            return ApiResult.error();
        }
    }
}
