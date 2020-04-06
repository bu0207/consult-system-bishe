package com.consult_system.controller;

import com.consult_system.entity.TrainDirection;
import com.consult_system.service.SystemDevelopDirectionService;
import com.consult_system.service.TrainDirectionService;
import com.consult_system.util.JSONUtils;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemDevelopDirectionController {
    public SystemDevelopDirectionService systemDevelopDirectionService;
    @Autowired
    public void setSystemDevelopDirectionService(SystemDevelopDirectionService systemDevelopDirectionService){
        this.systemDevelopDirectionService = systemDevelopDirectionService;
    }
    @Autowired
    private TrainDirectionService trainDirectionService;

    /**
     * 根据培养方向id查询所对应流程
     * @param trainDirectionId
     * @return
     */
    @RequestMapping(value = "/get/process",method = RequestMethod.POST)
    public ApiResult processGetByTrainDirectionId(Integer trainDirectionId){
        List<Map<String,Object>> list =  systemDevelopDirectionService.ProcessGetByTrainDirectionId(trainDirectionId);
        TrainDirection trainDirection = trainDirectionService.getDirectionById(trainDirectionId);
        String trainDirectionName = trainDirection.getTrainDirectionName();
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("trainDirectionName",trainDirectionName);
        resultMap.put("flowInfo",list);
        return ApiResult.ok(resultMap);
    }

    /**
     * 增加培养方向的流程
     * @param json
     * @param trainDirectionId
     * @return
     */
    @RequestMapping(value = "/insert/process",method = RequestMethod.POST)
    public ApiResult processInsert(@RequestBody String json, @RequestParam Integer trainDirectionId){
        if (!StringUtils.isEmpty(json) && JSONUtils.checkIsJson(json) && !StringUtils.isEmpty(trainDirectionService.getDirectionById(trainDirectionId))){
            systemDevelopDirectionService.processInsert(json, trainDirectionId);
        }else {
            return ApiResult.error();
        }
        return ApiResult.ok();
    }

    /**
     * 删除流程
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/process", method = RequestMethod.POST)
    public ApiResult processDelete(Integer id){
        return ApiResult.ok(systemDevelopDirectionService.processDelete(id));
    }

    /**
     * 修改流程
     * @param json
     * @param trainDirectionId
     * @return
     */
    @RequestMapping(value = "/alter/process",method = RequestMethod.POST)
    public ApiResult processAlter(@RequestBody String json, @RequestParam Integer trainDirectionId){
        if (!StringUtils.isEmpty(json) && JSONUtils.checkIsJson(json)){
            if (!StringUtils.isEmpty(trainDirectionService.getDirectionById(trainDirectionId))){
                return ApiResult.ok(systemDevelopDirectionService.processAlter(json, trainDirectionId));
            }else{
                return ApiResult.error("无法找到培养方向");
            }
        }else {
            return ApiResult.error();
        }
    }

    /**
     * 根据id查询流程
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/process/byId", method = RequestMethod.POST)
    public ApiResult processById(Integer id){
        return ApiResult.ok(systemDevelopDirectionService.processById(id));
    }


}
