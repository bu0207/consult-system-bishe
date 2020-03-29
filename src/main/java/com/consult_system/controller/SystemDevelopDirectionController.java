package com.consult_system.controller;

import com.consult_system.service.SystemDevelopDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemDevelopDirectionController {
    public SystemDevelopDirectionService systemDevelopDirectionService;
    @Autowired
    public void setSystemDevelopDirectionService(SystemDevelopDirectionService systemDevelopDirectionService){
        this.systemDevelopDirectionService = systemDevelopDirectionService;
    }
}
