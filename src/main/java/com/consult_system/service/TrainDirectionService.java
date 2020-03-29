package com.consult_system.service;

import com.consult_system.entity.TrainDirection;
import com.consult_system.repo.TrainDirectionRepo;
import com.consult_system.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrainDirectionService {

    private TrainDirectionRepo trainDirectionRepo;
    @Autowired
    public void setTrainDirectionRepo (TrainDirectionRepo trainDirectionRepo){
        this.trainDirectionRepo = trainDirectionRepo;
    }

    public List<TrainDirection> getAllTrainDirection(){
        return trainDirectionRepo.getAllTrainDirection();
    }

    public void insertTrainDirection(String json){
        Map<String,Object> map = JSONUtils.toMap(json);
        TrainDirection trainDirection = new TrainDirection();
        trainDirection.setCertificate(map.get("certificate").toString());
        trainDirection.setTrainDirectionContent(map.get("trainDirectionContent").toString());
        trainDirection.setTrainDirectionName(map.get("trainDirectionName").toString());
        trainDirectionRepo.save(trainDirection);
    }
}
