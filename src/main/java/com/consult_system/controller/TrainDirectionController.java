package com.consult_system.controller;

import com.alibaba.fastjson.JSONException;
import com.consult_system.service.TrainDirectionService;
import com.consult_system.viewmodel.ApiResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
     * 后台-增加培养方向
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

    /**
     * 后台-删除培养方向
     */
    @RequestMapping(value = "/delete/train/direction",method = RequestMethod.POST)
    public ApiResult deleteTrainDirection(Integer id){
        return ApiResult.ok(trainDirectionService.deleteTrainDirection(id));
    }

    /**
     * 后台-修改培养方向
     */
    @RequestMapping(value = "/alter/train/direction",method = RequestMethod.POST)
    public ApiResult alterTrainDirection(@RequestParam("id") Integer id, @RequestBody String jsonData){
        try{
            JSONObject.parseObject(jsonData);
        }catch (JSONException ex){
            try {
                JSONObject.parseArray(jsonData);
            } catch (JSONException ex1) {
                return ApiResult.error("json格式不正确");
            }
        }
        if (!StringUtils.isEmpty(id) && !StringUtils.isEmpty(jsonData)) {
            trainDirectionService.alterTrainDirection(id, jsonData);
        } else {
            return ApiResult.error("数据异常");
        }
        return ApiResult.ok();
    }

    /**
     * 根据id查询培养方向
     */
    @RequestMapping(value = "/get/direction/byId",method = RequestMethod.POST)
    public ApiResult getDirectionById(Integer id){
        return ApiResult.ok(trainDirectionService.getDirectionById(id));
    }
}
