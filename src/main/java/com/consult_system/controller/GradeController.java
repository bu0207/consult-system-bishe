package com.consult_system.controller;

import com.consult_system.entity.Grade;
import com.consult_system.service.GradeService;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "/grade/info",method = RequestMethod.GET)
    public ApiResult gradeInfo(){
        return ApiResult.ok(gradeService.getGradeAll());
    }
}
