package com.consult_system.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.consult_system.entity.TrainProgram;
import com.consult_system.service.TrainProgramService;
import com.consult_system.util.MapUtil;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TrainProgramController {

    @Autowired
    private TrainProgramService trainProgramService;

    /**
     * 培养方案页面初始化数据获取
     *
     * @return
     */
    @RequestMapping(value = "/trainProgram/page/init", method = RequestMethod.GET)
    public ApiResult trainProgramPageInit() {
        List<TrainProgram> trainProgramList = trainProgramService.trainProgramPageInit();
        if (trainProgramList.size() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Map<String, Object>> resultList = new ArrayList<>();
            for (int i = 0; i < trainProgramList.size(); i++) {
                TrainProgram trainProgram = trainProgramList.get(i);
                Map<String, Object> map = MapUtil.beanToMap(trainProgram);
                String createTime = simpleDateFormat.format((Date) map.get("createTime"));
                String updateTime = simpleDateFormat.format((Date) map.get("updateTime"));
                map.put("createTime", createTime);
                map.put("updateTime", updateTime);
                resultList.add(map);
            }
            return ApiResult.ok(resultList);
        } else {
            return ApiResult.error();
        }
    }

    /**
     * 后台 --培养方案增加
     */
    @RequestMapping(value = "/trainProgram/add", method = RequestMethod.POST)
    public ApiResult trainProgramAdd(@RequestBody String jsonData) {
        if (!StringUtils.isEmpty(jsonData)) {
            try {
                JSONObject.parseObject(jsonData);
            } catch (JSONException ex) {
                try {
                    JSONObject.parseArray(jsonData);
                } catch (JSONException ex1) {
                    return ApiResult.error("json格式不正确");
                }
            }
            trainProgramService.trainProgramAdd(jsonData);
        } else {
            return ApiResult.error("数据传入为空");
        }
        return ApiResult.ok();
    }

    /**
     * 后台 -- 培养方案删除
     *
     * @return
     */
    @RequestMapping(value = "/trainProgram/delete", method = RequestMethod.DELETE)
    public ApiResult trainProgramDelete(Integer id) {
        if (!StringUtils.isEmpty(id)) {
            String string = trainProgramService.trainProgramDelete(id);
            if (string.equals("err")) {
                return ApiResult.error("无法查询到");
            }
        } else {
            return ApiResult.error();
        }
        return ApiResult.ok();
    }

    /**
     * 后台 -- 培养方案修改
     *
     * @param id
     * @param jsonData
     * @return
     */
    @RequestMapping(value = "/trainProgram/alter", method = RequestMethod.POST)
    public ApiResult trainProgramAlter(@RequestParam("id") Integer id, @RequestBody String jsonData) {
        if (!StringUtils.isEmpty(id) && !StringUtils.isEmpty(jsonData)) {
            trainProgramService.trainProgramAlter(id, jsonData);
        } else {
            return ApiResult.error("数据异常");
        }
        return ApiResult.ok();
    }

    /**
     * 根据培养方案id查询单个培养方案
     * @param id
     * @return
     */
    @RequestMapping(value = "/trainProgram/findById", method = RequestMethod.GET)
    public ApiResult trainProgramFindById(Integer id) {
        if (!StringUtils.isEmpty(id)){
            return ApiResult.ok(trainProgramService.findTrainProgramById(id));
        }else {
            return ApiResult.error();
        }
    }

    /**
     * 根据年级查询培养方案
     * @param grade
     * @return
     */
    @RequestMapping(value = "/trainProgram/findByGrade",method = RequestMethod.GET)
    public ApiResult findTrainProgramByGrade(Integer grade){
        if (!StringUtils.isEmpty(grade)){
            return ApiResult.ok(trainProgramService.findTrainProgramByGrade(grade));
        }else {
            return ApiResult.error();
        }
    }
}
