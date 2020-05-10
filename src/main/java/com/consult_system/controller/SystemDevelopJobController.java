package com.consult_system.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.consult_system.repo.SystemDevelopDirectionRepo;
import com.consult_system.service.SystemDevelopJobService;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SystemDevelopJobController {
    @Autowired
    private SystemDevelopJobService systemDevelopJobService;

    /**
     * 根据流程id查询相关岗位
     *
     * @param flowId
     * @return
     */
    @RequestMapping(value = "/query/job", method = RequestMethod.POST)
    public ApiResult queryTrainDirectionJob(Integer flowId) {
        return ApiResult.ok(systemDevelopJobService.queryTrainDirectionJob(flowId));
    }

    /**
     * 删除岗位
     *
     * @param jobId
     * @return
     */
    @RequestMapping(value = "/delete/job", method = RequestMethod.POST)
    public ApiResult deleteTrainDirectionJob(Integer jobId) {
        return ApiResult.ok(systemDevelopJobService.deleteTrainDirectionJob(jobId));
    }


    /**
     * 修改岗位
     *
     * @param json
     * @param flowId
     * @param jobId
     * @return
     */
    @RequestMapping(value = "/alter/job", method = RequestMethod.POST)
    public ApiResult alterTrainDirectionJob(@RequestBody String json, @RequestParam("flowId") Integer flowId, @RequestParam("jobId") Integer jobId) {
        try {
            JSONObject.parseObject(json);
            return ApiResult.ok(systemDevelopJobService.alterTrainDirectionJob(json, jobId, flowId));
        } catch (JSONException ex) {
            try {
                JSONObject.parseArray(json);
            } catch (JSONException ex1) {
                return ApiResult.error("json格式不正确");
            }
        }
        return ApiResult.error();
    }

    /**
     * 新增岗位
     *
     * @param json
     * @return
     */
    @RequestMapping(value = "/add/job", method = RequestMethod.POST)
    public ApiResult addTrainDirectionJob(@RequestBody String json) {
        try {
            JSONObject.parseObject(json);
            return ApiResult.ok(systemDevelopJobService.addTrainDirectionJob(json));
        } catch (JSONException ex) {
            try {
                JSONObject.parseArray(json);
            } catch (JSONException ex1) {
                return ApiResult.error("json格式不正确");
            }
        }
        return ApiResult.error();
    }

    /**
     * 查询所有工作列表 分页
     * @return
     */
    @RequestMapping(value = "/query/jobList", method = RequestMethod.POST)
    public ApiResult queryJobList(Integer current, Integer pageSize){
        return ApiResult.ok(systemDevelopJobService.queryJobList(current, pageSize));
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ApiResult test(Integer currentPage, Integer pageSize, Integer id){
        return ApiResult.error(systemDevelopJobService.test(currentPage, pageSize, id));
    }
}
