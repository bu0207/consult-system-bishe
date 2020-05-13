package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "video")
public class Video extends BaseObject {

    private String videoUrl;

    private String fileName;

    private String fileOperate;
}
