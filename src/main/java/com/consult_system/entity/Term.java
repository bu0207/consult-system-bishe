package com.consult_system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "term")
public class Term {

    @Id
    private Object id;

    /**
     * 学期名
     */
    @Field("name")
    private String name;

    /**
     * 关联课程id
     */
    @Field("course_detail")
    private List<String> courseDetail;

    /**
     * 所属课程体系
     */
    @Field("system_id")
    private String courseSystemId;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(List<String> courseDetail) {
        this.courseDetail = courseDetail;
    }

    public String getCourseSystemId() {
        return courseSystemId;
    }

    public void setCourseSystemId(String courseSystemId) {
        this.courseSystemId = courseSystemId;
    }
}
