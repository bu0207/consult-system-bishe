package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jacob
 * 课程体系
 */

@Entity
@Table(name = "course_system")
@Data
public class CourseSystem extends BaseObject {

    public Integer gradeId;

    public String program;
}
