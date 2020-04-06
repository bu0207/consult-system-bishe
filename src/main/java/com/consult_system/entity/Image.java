package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "image")
@EqualsAndHashCode(callSuper=true)
public class Image extends BaseObject {

    public String imageUrl;
}
