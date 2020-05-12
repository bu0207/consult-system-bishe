package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.annotation.Documented;
import java.util.List;


/**
 * @author jacob
 * 课程体系
 */

@Document(collection = "course_system")
public class CourseSystem implements Serializable {

    @Id
    private Object id;
    /**
     * 课程体系名称
     */
    @Field("name")
    public String systemName;

    /**
     * 所含培养方向
     */
    @Field("direction_detail")
    public List<String> program;

    /**
     * 所含学期
     */
    @Field("term_detail")
    private List<String> term;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public List<String> getProgram() {
        return program;
    }

    public void setProgram(List<String> program) {
        this.program = program;
    }

    public List<String> getTerm() {
        return term;
    }

    public void setTerm(List<String> term) {
        this.term = term;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }
}
