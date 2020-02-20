package com.consult_system.service;

import com.consult_system.entity.CourseSystem;
import com.consult_system.repo.CourseSystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSystemService {

    @Autowired
    private CourseSystemRepo courseSystemRepo;

    public CourseSystem findOneById(Integer id){
        return courseSystemRepo.findOneById(id);
    }
}
