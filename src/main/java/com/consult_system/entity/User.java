package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jacob
 * @date 2019/12/30
 * @description 用户信息
 */

@Entity
@Table(name = "user")
@Data
public class User extends BaseObject {

    public  String name;

    public String password;

    public String studentId;

    public String role;
}
