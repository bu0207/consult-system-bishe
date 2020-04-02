package com.consult_system.controller;

import com.consult_system.repo.SystemDevelopDirectionRepo;
import com.consult_system.service.SystemDevelopJobService;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemDevelopJobController {
    @Autowired
    private SystemDevelopJobService systemDevelopJobService;

    // 查询岗位
    @RequestMapping(value = "/query/job",method = RequestMethod.POST)
    public ApiResult queryTrainDirectionJob(Integer id){
        return ApiResult.ok(systemDevelopJobService.queryTrainDirectionJob(id));
    }
}
