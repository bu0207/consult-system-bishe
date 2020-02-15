package com.consult_system.service;

import com.consult_system.entity.TrainProgram;
import com.consult_system.repo.TrainProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainProgramService {

    @Autowired
    private TrainProgramRepo trainProgramRepo;

    public List<TrainProgram> trainProgramPageInit() {
        return trainProgramRepo.trainProgramPageInit();
    }
}
