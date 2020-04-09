package com.consult_system.service;

import com.consult_system.entity.SystemDevelopDirection;
import com.consult_system.repo.SystemDevelopDirectionRepo;
import com.consult_system.util.JSONUtils;
import com.consult_system.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SystemDevelopDirectionService {

    private SystemDevelopDirectionRepo systemDevelopDirectionRepo;
    @Autowired
    public void setSystemDevelopDirectionRepo(SystemDevelopDirectionRepo systemDevelopDirectionRepo){
        this.systemDevelopDirectionRepo = systemDevelopDirectionRepo;
    }

    public List<Map<String,Object>> ProcessGetByTrainDirectionId(Integer trainDirectionId){
        List<Map<String,Object>> resultList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<SystemDevelopDirection> list =  systemDevelopDirectionRepo.findAllByTrainDirectionId(trainDirectionId);
        for (int i=0; i<list.size(); i++){
            Map<String,Object> map = MapUtil.beanToMap(list.get(i));
            Object flowIntro = map.get("flowIntro");
            String createTime = simpleDateFormat.format((Date) map.get("createTime"));
            String updateTime = simpleDateFormat.format((Date) map.get("updateTime"));
            map.put("createTime", createTime);
            map.put("updateTime", updateTime);
            map.put("flowIntro",flowIntro.toString().split("#"));
            resultList.add(map);
        }
        return resultList;
    }

    public void processInsert(String json, Integer trainDirectionId){
        Map<String,Object> map = JSONUtils.toMap(json);
        SystemDevelopDirection systemDevelopDirection = new SystemDevelopDirection();
        systemDevelopDirection.setFlowName(map.get("flowName").toString());
        systemDevelopDirection.setFlowIntro(map.get("flowIntro").toString());
        systemDevelopDirection.setTrainDirectionId(trainDirectionId);
        systemDevelopDirection.setCreateTime(new Date());
        systemDevelopDirectionRepo.save(systemDevelopDirection);
    }

    public String processAlter(String json, Integer trainDirectionId){
        Map<String,Object> map = JSONUtils.toMap(json);
        SystemDevelopDirection systemDevelopDirection = systemDevelopDirectionRepo.findSystemDevelopDirectionByKeyId(Integer.valueOf(map.get("keyId").toString()));
        if (!StringUtils.isEmpty(systemDevelopDirection)){
            systemDevelopDirection.setFlowName(map.get("flowName").toString());
            systemDevelopDirection.setFlowIntro(map.get("flowIntro").toString());
            systemDevelopDirection.setTrainDirectionId(trainDirectionId);
            systemDevelopDirection.setUpdateTime(new Date());
            systemDevelopDirectionRepo.save(systemDevelopDirection);
            return "修改成功";
        }else {
            return "无法找到该流程";
        }
    }

    public String processDelete(Integer id){
        SystemDevelopDirection systemDevelopDirection = systemDevelopDirectionRepo.findSystemDevelopDirectionByKeyId(id);
        if (!StringUtils.isEmpty(systemDevelopDirection)){
            systemDevelopDirection.setIsDeleted(1);
            systemDevelopDirectionRepo.save(systemDevelopDirection);
            return "删除成功";
        }else {
            return "无法找到要删除的流程";
        }
    }

    public Map<String,Object> processById(Integer id){
        SystemDevelopDirection systemDevelopDirection = systemDevelopDirectionRepo.findSystemDevelopDirectionByKeyId(id);
        Map<String,Object> map = MapUtil.beanToMap(systemDevelopDirection);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Object flowIntro = map.get("flowIntro");
        String createTime = simpleDateFormat.format((Date) map.get("createTime"));
        String updateTime = simpleDateFormat.format((Date) map.get("updateTime"));
        map.put("createTime", createTime);
        map.put("updateTime", updateTime);
        map.put("flowIntro",flowIntro.toString().split("#"));
        return map;
    }
}
