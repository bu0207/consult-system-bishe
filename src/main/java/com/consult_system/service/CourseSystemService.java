package com.consult_system.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.consult_system.entity.*;
import com.consult_system.repo.CourseSystemRepo;
import com.consult_system.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class CourseSystemService {

    @Autowired
    private CourseSystemRepo courseSystemRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

//    public CourseSystem findOneById(Integer id){
//        return courseSystemRepo.findOneById(id);
//    }

    public Map<String, Object> queryCourseSystem(String courseSystemName, String type) {
        Criteria criteria = new Criteria();
        Map<String, Object> resultMap = new HashMap<>();
        criteria.and("name").is(courseSystemName);
        Query query = new Query(criteria);
        CourseSystem courseSystem = mongoTemplate.findOne(query, CourseSystem.class);
        String systemName = courseSystem.getSystemName();
        resultMap.put("name", systemName);
        Object id = courseSystem.getId();
        System.out.println("id<<<<<<<<<<<" + id);
        List<String> programList = courseSystem.getProgram();
        List<String> termList = courseSystem.getTerm();
        System.out.println(systemName);
        System.out.println(courseSystem.getProgram());
        System.out.println(courseSystem.getTerm());
        List<Map<String, Object>> termResultList = new ArrayList<>();
        if (type.equals("term")) {
            for (String termId : termList) {
                System.out.println("termid<<<<<<" + termId);
                Map<String, Object> termResultMap = new HashMap<>();
                Criteria criteria2 = new Criteria();
                criteria2.and("_id").is(termId);
                Term term = mongoTemplate.findOne(new Query(criteria2), Term.class);
                List<String> courseDetail = term.getCourseDetail();
                termResultMap.put("name", term.getName());
                List<Map<String, Object>> courseResultList = new ArrayList<>();
                for (String courseId : courseDetail) {
                    System.out.println("courseid<<<<<<<<<" + courseId);
                    Map<String, Object> courseMap = new HashMap<>();
                    Criteria criteria3 = new Criteria();
                    criteria2.and("_id").is(courseId);
                    Course course = mongoTemplate.findOne(new Query(criteria3), Course.class);
                    courseMap.put("name", course.getName());
                    courseResultList.add(courseMap);
                }
                termResultMap.put("children", courseResultList);
                termResultList.add(termResultMap);
            }
            resultMap.put("children", termResultList);
        } else if (type.equals("direction")) {
            for (String programId : programList) {
                System.out.println("termid<<<<<<" + programId);
                Map<String, Object> programResultMap = new HashMap<>();
                Criteria criteria2 = new Criteria();
                criteria2.and("_id").is(programId);
                Direction direction = mongoTemplate.findOne(new Query(criteria2), Direction.class);
                List<String> courseDetail = direction.getCourseDetail();
                programResultMap.put("name", direction.getName());
                List<Map<String, Object>> courseResultList = new ArrayList<>();
                for (String courseId : courseDetail) {
                    System.out.println("courseid<<<<<<<<<" + courseId);
                    Map<String, Object> courseMap = new HashMap<>();
                    Criteria criteria3 = new Criteria();
                    criteria2.and("_id").is(courseId);
                    Course course = mongoTemplate.findOne(new Query(criteria3), Course.class);
                    courseMap.put("name", course.getName());
                    courseResultList.add(courseMap);
                }
                programResultMap.put("children", courseResultList);
                termResultList.add(programResultMap);
            }
            resultMap.put("children", termResultList);
        }
        return resultMap;
    }

    /**
     * 根据课程体系名称和类型查询
     *
     * @param courseSystemName
     * @param type
     * @return
     */
    public List<CourseJsonDate> courseSystemGetJsonDate(String courseSystemName, String type) {
        return courseSystemRepo.findList(courseSystemName, type);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Map<String, Object> courseSystemGetJsonDateById(Integer id) {
        CourseJsonDate courseJsonDate = courseSystemRepo.findOneByKeyId(id);
        String json = courseJsonDate.getCourseSystemJson();
        System.out.println("json1<<" + json);
        //定义两种不同格式的字符串
        String objectStr = "{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}";
        String arrayStr = "[{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}]";

        //1、使用JSONObject
        JSONObject jsonObject = JSONObject.parseObject(objectStr);
        System.out.println("1111<<<<<<<<<" + jsonObject);
        System.out.println("json2<<<<" + JSONObject.parseObject(json));
        System.out.println("json3<<<<" + JSONObject.parseObject(json.replaceAll(" ", "")));

        Map<String, Object> map = new HashMap<>();
        map.put("courseSystemName", courseJsonDate.getCourseSystemName());
        map.put("courseSystemJson", JSONObject.parseObject(courseJsonDate.getCourseSystemJson()));
        map.put("courseType", courseJsonDate.getCourseType());

        return map;
    }

    /**
     * 查询列表
     *
     * @return
     */
    public List<Map<String, Object>> courseSystemGetJsonDateList() {
        List<CourseJsonDate> list = courseSystemRepo.findCourseJsonDateList();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (CourseJsonDate courseJsonDate : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("keyId", courseJsonDate.getKeyId());
            map.put("courseSystemName", courseJsonDate.getCourseSystemName());
            map.put("courseSystemJson", JSONObject.parseObject(courseJsonDate.getCourseSystemJson()));
            map.put("courseType", courseJsonDate.getCourseType());
            list1.add(map);
        }
        return list1;
    }

    /**
     * 修改课程体系
     *
     * @param courseSystemName
     * @param courseSystemJson
     * @param courseType
     * @param id
     * @return
     */
    public String courseSystemGetJsonDateUpdate(String courseSystemName, String courseSystemJson, String courseType, Integer id) {
        CourseJsonDate courseJsonDate = courseSystemRepo.findOneByKeyId(id);
        if (null != courseJsonDate) {
            if (!StringUtils.isEmpty(courseSystemJson)) {
                courseJsonDate.setCourseSystemJson(courseSystemJson);
            }
            if (!StringUtils.isEmpty(courseSystemName)) {
                courseJsonDate.setCourseSystemName(courseSystemName);
            }
            if (!StringUtils.isEmpty(courseType)) {
                courseJsonDate.setCourseType(courseType);
            }
            courseJsonDate.setUpdateTime(new Date());
            courseSystemRepo.save(courseJsonDate);
            return "成功";
        } else {
            return "失败";
        }
    }

    /**
     * 新增课程体系
     *
     * @param courseSystemName
     * @param courseSystemJson
     * @param courseType
     * @return
     */
    public String courseSystemGetJsonDateInsert(String courseSystemName, String courseSystemJson, String courseType) {
        CourseJsonDate courseJsonDate = new CourseJsonDate();
        if (!StringUtils.isEmpty(courseSystemJson)) {
            courseJsonDate.setCourseSystemJson(courseSystemJson);
        }
        if (!StringUtils.isEmpty(courseSystemName)) {
            courseJsonDate.setCourseSystemName(courseSystemName);
        }
        if (!StringUtils.isEmpty(courseType)) {
            courseJsonDate.setCourseType(courseType);
        }
        courseSystemRepo.save(courseJsonDate);
        return "成功";
    }
}
