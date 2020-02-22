package com.consult_system.service;

import com.consult_system.entity.Grade;
import com.consult_system.repo.GradeRepo;
import com.consult_system.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeService {

    @Autowired
    private GradeRepo gradeRepo;

    public List<Map<String,Object>> getGradeAll() {
        List<Grade> list = gradeRepo.getGradeAll();
        List<Map<String,Object>> resultList = new ArrayList<>();
        for (int i=0; i < list.size(); i++) {
            Map<String,Object> map = MapUtil.beanToMap(list.get(i));
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("keyId",map.get("keyId"));
            resultMap.put("grade",map.get("grade"));
            resultList.add(resultMap);
        }
        return resultList;
    }
}
