package com.consult_system.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.consult_system.entity.CourseJsonDate;
import com.consult_system.service.CourseSystemService;
import com.consult_system.viewmodel.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author jacob
 */
@RestController
public class CourseSystemController {

    private Logger logger = LoggerFactory.getLogger(CourseSystemController.class);
    @Autowired
    private CourseSystemService courseSystemService;
    @Autowired
    private HttpServletRequest request;

//    @RequestMapping(value ="/get/image",method = RequestMethod.GET)
//    public String getImage(){
//        return courseSystemService.findOneById(1).getProgram();
//    }

    @RequestMapping(value = "/List", method = RequestMethod.POST)
    public ApiResult getTestList() {

        return ApiResult.ok(courseSystemService.queryCourseSystem("一六级课程体系", "term"));
    }

    /**
     * @param courseSystemName
     * @param type             type : term 分学期  direction :培养方向
     * @return
     */
    @RequestMapping(value = "/courseSystem/List", method = RequestMethod.POST)
    public ApiResult queryCourseList(String courseSystemName, String type) {
        return ApiResult.ok(courseSystemService.queryCourseSystem(courseSystemName, type));
    }

    /**
     * 根据课程体系名称和类型查询
     *
     * @param courseSystemName
     * @param type
     * @return
     */
    @RequestMapping(value = "/courseSystem/getJsonDate", method = RequestMethod.POST)
    public ApiResult courseSystemGetJsonDate(String courseSystemName, String type) {
        List<CourseJsonDate> courseJsonDateList = courseSystemService.courseSystemGetJsonDate(courseSystemName, type);
        if (courseJsonDateList.size() > 0) {
            return ApiResult.ok(courseJsonDateList.get(0));
        }
        return ApiResult.error("无法查询");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/courseSystem/getById", method = RequestMethod.POST)
    public ApiResult courseSystemGetJsonDateById(Integer id) {
        return ApiResult.ok(courseSystemService.courseSystemGetJsonDateById(id));
    }

    /**
     * 查询列表
     *
     * @return
     */
    @RequestMapping(value = "/courseSystem/getList", method = RequestMethod.POST)
    public ApiResult courseSystemGetJsonDateList() {
        return ApiResult.ok(courseSystemService.courseSystemGetJsonDateList());
    }

    /**
     * 更新课程体系
     *
     * @param courseSystemName
     * @param courseSystemJson
     * @param courseType
     * @param id
     * @return
     */
    @RequestMapping(value = "/courseSystem/updateById", method = RequestMethod.POST)
    public ApiResult courseSystemGetJsonDateUpdate(@RequestParam("courseSystemName") String courseSystemName, @RequestBody String courseSystemJson, @RequestParam("courseType") String courseType, Integer id) {
        try {
            JSONObject.parseObject(courseSystemJson);
        } catch (JSONException ex) {
            try {
                JSONObject.parseArray(courseSystemJson);
            } catch (JSONException ex1) {
                return ApiResult.error("json格式不正确");
            }
        }
        return ApiResult.ok(courseSystemService.courseSystemGetJsonDateUpdate(courseSystemName, courseSystemJson, courseType, id));

    }

    /**
     * 新增课程体系
     *
     * @param courseSystemName
     * @param courseSystemJson
     * @param courseType
     * @return
     */
    @RequestMapping(value = "/courseSystem/insert", method = RequestMethod.POST)
    public ApiResult courseSystemGetJsonDateInsert(@RequestParam("courseSystemName") String courseSystemName, @RequestBody String courseSystemJson, @RequestParam("courseType") String courseType) {
        try {
            JSONObject.parseObject(courseSystemJson);
        } catch (JSONException ex) {
            try {
                JSONObject.parseArray(courseSystemJson);
            } catch (JSONException ex1) {
                return ApiResult.error("json格式不正确");
            }
        }
        return ApiResult.ok(courseSystemService.courseSystemGetJsonDateInsert(courseSystemName, courseSystemJson, courseType));
    }
}
