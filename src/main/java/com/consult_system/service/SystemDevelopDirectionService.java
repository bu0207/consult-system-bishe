package com.consult_system.service;

import com.consult_system.repo.SystemDevelopDirectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemDevelopDirectionService {

    private SystemDevelopDirectionRepo systemDevelopDirectionRepo;
    @Autowired
    public void setSystemDevelopDirectionRepo(SystemDevelopDirectionRepo systemDevelopDirectionRepo){
        this.systemDevelopDirectionRepo = systemDevelopDirectionRepo;
    }
}
