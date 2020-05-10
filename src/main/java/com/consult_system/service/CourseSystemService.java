package com.consult_system.service;

import com.consult_system.entity.Course;
import com.consult_system.entity.CourseSystem;
import com.consult_system.entity.Term;
import com.consult_system.repo.CourseSystemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseSystemService {

    //    @Autowired
//    private CourseSystemRepo courseSystemRepo;
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
        System.out.println("id<<<<<<<<<<<" +id);
        List<String> program = courseSystem.getProgram();
        List<String> termList = courseSystem.getTerm();
        System.out.println(systemName);
        System.out.println(courseSystem.getProgram());
        System.out.println(courseSystem.getTerm());
        List<Map<String, Object>> termResultList = new ArrayList<>();
        if (type.equals("term")) {
            for (String termId : termList) {
                Map<String, Object> termResultMap = new HashMap<>();
                Criteria criteria2 = new Criteria();
                criteria2.and("_id").is(termId);
                Term term = mongoTemplate.findOne(new Query(criteria2), Term.class);
                List<String> courseDetail = term.getCourseDetail();
                termResultMap.put("name", term.getName());
                List<Map<String,Object>> courseResultList = new ArrayList<>();
                for (String courseId : courseDetail) {
                    Map<String, Object> courseMap = new HashMap<>();
                    Criteria criteria3 = new Criteria();
                    criteria2.and("_id").is(courseId);
                    Course course = mongoTemplate.findOne(new Query(criteria3), Course.class);
                    courseMap.put("name", course.getName());
                    courseResultList.add(courseMap);
                }
                termResultMap.put("children",courseResultList);
                termResultList.add(termResultMap);
            }
        }
        resultMap.put("children",termResultList);
        return resultMap;
    }
}
