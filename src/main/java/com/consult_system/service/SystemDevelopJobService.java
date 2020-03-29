package com.consult_system.service;

import com.consult_system.entity.SystemDevelopDirection;
import com.consult_system.entity.SystemDevelopJob;
import com.consult_system.repo.SystemDevelopDirectionRepo;
import com.consult_system.repo.SystemDevelopJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemDevelopJobService {
    @Autowired
    private SystemDevelopJobRepo systemDevelopJobRepo;
    @Autowired
    private SystemDevelopDirectionRepo systemDevelopDirectionRepo;


    public List<Map<String,Object>> queryTrainDirectionJob(Integer id){
        List<SystemDevelopDirection> list = systemDevelopDirectionRepo.findAllByTrainDirectionId(id);
        List<Map<String,Object>> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            SystemDevelopDirection systemDevelopDirection = list.get(i);
            Map<String,Object> map = new HashMap<>();
            Integer keyId = systemDevelopDirection.getKeyId();
            List<SystemDevelopJob> systemDevelopJobList = systemDevelopJobRepo.findAllBySystemDevelopDirectionId(keyId);
            map.put("flowName",systemDevelopDirection.getFlowName());
            map.put("flowIntro",systemDevelopDirection.getFlowIntro());
            map.put("jobInfo",systemDevelopJobList);
            resultList.add(map);
        }
        return resultList;
    }
}
