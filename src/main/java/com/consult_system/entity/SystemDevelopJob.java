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

    /**
     * 关联培养方向流程id
     */
    public Integer systemDevelopDirectionId;

    /**
     * 岗位名字
     */
    public String jobName;

    /**
     * 岗位要求
     */
    public String jobRequire;

    /**
     * 职位列举
     */
    public String jobList;

    /**
     * 工作内容
     */
    public String jobContent;
}
