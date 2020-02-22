package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "grade")
public class Grade extends BaseObject {

    public String grade;
}
