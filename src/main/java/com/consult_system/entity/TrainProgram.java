package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @description 培养方案
 */
@Entity
@Table(name = "train_programe")
@Data
@EqualsAndHashCode(callSuper=true)

public class TrainProgram extends BaseObject {

    public Integer gradeId;

    public Integer grade;

    public String trainGoal;

    public String trainGoalIntroduce;

    public String trainGoalDetail;

    public String trainSpecial;

    public String trainSpecialIntroduce;

    public String mainCourse;

    public String mainCourseIntroduce;

    public String educationalSystem;

    public String educationalSystemDetail;

    public String creditRequirment;

    public String creditRequirementIntroduce;

    public String creditRequirementDetail;

    public String conferDegree;

    public String conferDegreeIntroduce;
}
