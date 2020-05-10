package com.consult_system.service;

import com.consult_system.entity.TrainDirection;
import com.consult_system.repo.TrainDirectionRepo;
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
public class TrainDirectionService {

    private TrainDirectionRepo trainDirectionRepo;
    @Autowired
    public void setTrainDirectionRepo (TrainDirectionRepo trainDirectionRepo){
        this.trainDirectionRepo = trainDirectionRepo;
    }

    public List<Map<String,Object>> getAllTrainDirection(){
        List<TrainDirection> list = trainDirectionRepo.getAllTrainDirection();
        List<Map<String,Object>> resultList = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            Map<String,Object> map = MapUtil.beanToMap(list.get(i));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map.put("updateTime",simpleDateFormat.format(map.get("updateTime")));
            map.put("createTime",simpleDateFormat.format(map.get("createTime")));
            resultList.add(map);
        }
        return resultList;
    }

    public void insertTrainDirection(String json){
        Map<String,Object> map = JSONUtils.toMap(json);
        TrainDirection trainDirection = new TrainDirection();
        trainDirection.setCertificate(map.get("certificate").toString());
        trainDirection.setTrainDirectionContent(map.get("trainDirectionContent").toString());
        trainDirection.setTrainDirectionName(map.get("trainDirectionName").toString());
        trainDirection.setCreateTime(
                new Date());
        if (!StringUtils.isEmpty(map.get("picture"))){
            trainDirection.setPicture(map.get("picture").toString());
        }
        trainDirectionRepo.save(trainDirection);
    }

    public String deleteTrainDirection(Integer id){
        TrainDirection trainDirection = trainDirectionRepo.findByKeyId(id);
        if (!StringUtils.isEmpty(trainDirection)){
            trainDirection.setIsDeleted(1);
            trainDirectionRepo.save(trainDirection);
        }else {
            return "错误";
        }
        return "操作成功";
    }

    public void alterTrainDirection(Integer id,String jsonData){
        Map<String,Object> map = JSONUtils.toMap(jsonData);
        TrainDirection trainDirection = trainDirectionRepo.findByKeyId(id);
        if (!StringUtils.isEmpty(trainDirection)){
            trainDirection.setTrainDirectionName(map.get("trainDirectionName").toString());
            trainDirection.setTrainDirectionContent(map.get("trainDirectionContent").toString());
//            trainDirection.setCertificate(map.get("certificate").toString());
            if (!StringUtils.isEmpty(map.get("picture"))){
                trainDirection.setPicture(map.get("picture").toString());
            }
            trainDirection.setUpdateTime(new Date());
            trainDirectionRepo.save(trainDirection);
        }
    }

    public TrainDirection getDirectionById(Integer id){
        return trainDirectionRepo.findByKeyId(id);
    }
}
