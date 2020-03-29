package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jacob
 * @description 信息系统开发方向岗位
 * @date 2020/3/22
 */

@Entity
@Table(name = "system_develop_job")
@Data
public class SystemDevelopJob extends BaseObject {

    public Integer systemDevelopDirectionId;

    public String tag;

    public String jobName;

    public String jobRequire;

    public String jobList;
}
