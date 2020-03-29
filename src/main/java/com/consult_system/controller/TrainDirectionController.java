package com.consult_system.controller;

import com.alibaba.fastjson.JSONException;
import com.consult_system.service.TrainDirectionService;
import com.consult_system.viewmodel.ApiResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jacob
 * @date 2020/3/22
 */

@RestController
public class TrainDirectionController {

    @Autowired
    private TrainDirectionService trainDirectionService;

    /**
     * 查询培养方向
     * @return
     */
    @RequestMapping(value = "/get/trainDirection",method = RequestMethod.POST)
    public ApiResult getAllTrainDirection(){
        return ApiResult.ok(trainDirectionService.getAllTrainDirection());
    }

    /**
     * 增加培养方向
     * @param json
     * @return
     */
    @RequestMapping(value = "/insert/trainDirection",method = RequestMethod.POST)
    public ApiResult insertTrainDirection(@RequestBody String json){
        try{
            JSONObject.parseObject(json);
        }catch (JSONException ex){
            try {
                JSONObject.parseArray(json);
            } catch (JSONException ex1) {
                return ApiResult.error("json格式不正确");
            }
        }
        trainDirectionService.insertTrainDirection(json);
        return ApiResult.ok();
    }

}
