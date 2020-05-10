package com.consult_system.service;

import com.consult_system.entity.SystemDevelopDirection;
import com.consult_system.entity.SystemDevelopJob;
import com.consult_system.repo.SystemDevelopDirectionRepo;
import com.consult_system.repo.SystemDevelopJobRepo;
import com.consult_system.util.JSONUtils;
import com.consult_system.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Service
public class SystemDevelopJobService {
    @Autowired
    private SystemDevelopJobRepo systemDevelopJobRepo;
    @Autowired
    private SystemDevelopDirectionRepo systemDevelopDirectionRepo;

    @PersistenceContext
    EntityManager entityManager;

    /**
     * 查询
     * @param flowId
     * @return
     */
    public List<SystemDevelopJob> queryTrainDirectionJob(Integer flowId){
//        List<SystemDevelopDirection> list = systemDevelopDirectionRepo.findAllByTrainDirectionId(id);
//        List<Map<String,Object>> resultList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++){
//            SystemDevelopDirection systemDevelopDirection = list.get(i);
//            Map<String,Object> map = new HashMap<>();
//            Integer keyId = systemDevelopDirection.getKeyId();
            List<SystemDevelopJob> systemDevelopJobList = systemDevelopJobRepo.findAllBySystemDevelopDirectionId(flowId);
//            map.put("flowName",systemDevelopDirection.getFlowName());
//            map.put("flowIntro",systemDevelopDirection.getFlowIntro());
//            map.put("jobInfo",systemDevelopJobList);
//            resultList.add(map);
//        }
        return systemDevelopJobList;
    }

    /**
     * 删除
     * @param jobId
     * @return
     */
    public boolean deleteTrainDirectionJob(Integer jobId){
        SystemDevelopJob systemDevelopJob = systemDevelopJobRepo.findByJobId(jobId);
        if (null != systemDevelopJob){
            systemDevelopJob.setIsDeleted(1);
            systemDevelopJobRepo.save(systemDevelopJob);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 修改
     * @param json
     * @param jobId
     * @param flowId
     * @return
     */
    public boolean alterTrainDirectionJob(String json, Integer jobId, Integer flowId){
        SystemDevelopJob systemDevelopJob = systemDevelopJobRepo.findByJobId(jobId);
        SystemDevelopDirection systemDevelopDirection = systemDevelopDirectionRepo.findSystemDevelopDirectionByKeyId(flowId);
        Map<String,Object> map = JSONUtils.toMap(json);
        String jobName = null, jobRequire = null, jobContent = null, jobList = null;
        if (null != map.get("jobName")){
            jobName = map.get("jobName").toString();
        }
        if (null != map.get("jobRequire")){
            jobRequire = map.get("jobRequire").toString();
        }
        if (null != map.get("jobContent")){
            jobContent = map.get("jobContent").toString();
        }
        if (null != map.get("jobList").toString()){
            jobList = map.get("jobList").toString();
        }
        if (null != systemDevelopDirection && null != systemDevelopJob){
            systemDevelopJob.setJobName(jobName);
            systemDevelopJob.setJobRequire(jobRequire);
            systemDevelopJob.setJobContent(jobContent);
            systemDevelopJob.setJobList(jobList);
            systemDevelopJob.setSystemDevelopDirectionId(flowId);
            systemDevelopJob.setCreateTime(new Date());
            systemDevelopJobRepo.save(systemDevelopJob);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 增加
     * @param json
     * @return
     */
    public String addTrainDirectionJob(String json){
        Map<String,Object> map = JSONUtils.toMap(json);
//        Integer flowId = Integer.valueOf(map.get("flowId").toString());
//        SystemDevelopDirection systemDevelopDirection = systemDevelopDirectionRepo.findSystemDevelopDirectionByKeyId(flowId);
        String jobName = null, jobRequire = null, jobContent = null, jobList = null;
        if (null != map.get("jobName")){
            jobName = map.get("jobName").toString();
        }
        if (null != map.get("jobRequire")){
            jobRequire = map.get("jobRequire").toString();
        }
        if (null != map.get("jobContent")){
            jobContent = map.get("jobContent").toString();
        }
        if (null != map.get("jobList").toString()){
            jobList = map.get("jobList").toString();
        }
//        if (null != systemDevelopDirection){
            SystemDevelopJob systemDevelopJob = new SystemDevelopJob();
            systemDevelopJob.setJobName(jobName);
            systemDevelopJob.setJobRequire(jobRequire);
            systemDevelopJob.setJobContent(jobContent);
            systemDevelopJob.setJobList(jobList);
//            systemDevelopJob.setSystemDevelopDirectionId(flowId);
            systemDevelopJob.setCreateTime(new Date());
            systemDevelopJob.setUpdateTime(new Date());
            systemDevelopJobRepo.save(systemDevelopJob);
            return "成功";
//        }
//        return "失败";
    }


    public Page<SystemDevelopJob> queryJobList(Integer currentPage, Integer pageSize){
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<SystemDevelopJob> page =  systemDevelopJobRepo.queryByPage(pageable);
        List<SystemDevelopJob> list = page.getContent();
        return page;
    }

    public Map<String,Object> test(Integer currentPage, Integer pageSize, Integer id){
        StringBuilder countSelectSql = new StringBuilder();
        countSelectSql.append("select count(1) from SystemDevelopJob a where 1=1 ");
        StringBuilder selectSql = new StringBuilder();
        selectSql.append("select a from SystemDevelopJob a where 1=1 ");
        Map<String,Object> params = new HashMap<>();
        StringBuilder whereSql = new StringBuilder();
        whereSql.append(" and a.isDeleted = 0 ");

        if (null != id){
            whereSql.append(" and a.keyId =" + id);
        }
        //查询数量
        String countSql = new StringBuilder().append(countSelectSql).append(whereSql).toString();
        Query countQuery = this.entityManager.createQuery(countSql,Long.class);
        Long count = (Long)countQuery.getSingleResult();
        //查询结果
        String querySql = new StringBuilder().append(selectSql).append(whereSql).toString();
        Query query = this.entityManager.createQuery(querySql,SystemDevelopJob.class);
        //设置分页
        query.setFirstResult(currentPage);
        query.setMaxResults(pageSize);
        List<SystemDevelopJob> list = query.getResultList();

        //设置分页
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<SystemDevelopJob> page = new PageImpl<SystemDevelopJob>(list,pageable,count);

        Map<String,Object> map = new HashMap<>();
        map.put("count",count);
        map.put("list",list);
        map.put("page",page);
        return map;
    }

}
