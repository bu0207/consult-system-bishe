package com.consult_system.controller;

import com.consult_system.service.CourseSystemService;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jacob
 */
@RestController
public class CourseSystemController {

    @Autowired
    private CourseSystemService courseSystemService;

//    @RequestMapping(value ="/get/image",method = RequestMethod.GET)
//    public String getImage(){
//        return courseSystemService.findOneById(1).getProgram();
//    }

    @RequestMapping(value = "/List",method = RequestMethod.POST)
    public ApiResult getTestList(){

        return ApiResult.ok(courseSystemService.queryCourseSystem("一六级课程体系", "term"));
    }
}
