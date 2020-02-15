package com.consult_system.controller;

import com.consult_system.entity.TrainProgram;
import com.consult_system.service.TrainProgramService;
import com.consult_system.util.MapUtil;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TrainProgramController {

    @Autowired
    private TrainProgramService trainProgramService;

    @RequestMapping(value = "/trainProgram/page/init", method = RequestMethod.GET)
    public ApiResult trainProgramPageInit() {
        List<TrainProgram> trainProgramList = trainProgramService.trainProgramPageInit();
        if (trainProgramList.size() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            TrainProgram trainProgram = trainProgramList.get(0);
            Map<String, Object> map = MapUtil.beanToMap(trainProgram);
            String createTime = simpleDateFormat.format((Date) map.get("createTime"));
            String updateTime = simpleDateFormat.format((Date) map.get("updateTime"));
            map.put("createTime", createTime);
            map.put("updateTime", updateTime);
            return ApiResult.ok(map);
        } else {
            return ApiResult.error();
        }
    }
}
