package com.consult_system.service;

import com.consult_system.entity.Grade;
import com.consult_system.repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepo gradeRepo;

    public List<String> getGradeAll(){
        return gradeRepo.getGradeAll();
    }
}
