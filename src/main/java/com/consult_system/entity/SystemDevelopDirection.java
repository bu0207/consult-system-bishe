package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jacob
 * @description 信息系统开发方向
 * @date 2020/3/23
 */

@Entity
@Table(name = "system_develop_direction")
@Data
public class SystemDevelopDirection extends BaseObject {

    public Integer trainDirectionId;

    public String flowName;

    public String flowIntro;
}
