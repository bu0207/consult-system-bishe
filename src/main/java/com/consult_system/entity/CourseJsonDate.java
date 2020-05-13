package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "course_jaon_date")
public class CourseJsonDate extends BaseObject {
    /**
     * 课程体系名称
     */
    private String courseSystemName;

    /**
     * 课程体系json串
     */
    private String courseSystemJson;

    /**
     * 类别 term 分学期  direction :培养方向
     */
    private String courseType;
}
