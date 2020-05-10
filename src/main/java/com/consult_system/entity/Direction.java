package com.consult_system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "train_direction")
public class Direction {

    @Id
    private Object id;


    /**
     * 培养方向名称
     */
    @Field("name")
    private String name;

    /**
     * 关联课程id
     */
    @Field("course_id")
    private List<String> courseDetail;

    /**
     * 所属课程体系
     */
    @Field("course_system_id")
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
