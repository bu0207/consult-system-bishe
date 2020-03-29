package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jacob
 * @description 培养方向
 * @date 2020/3/23
 */

@Entity
@Table(name = "train_direction")
@Data
@EqualsAndHashCode(callSuper=true)
public class TrainDirection extends BaseObject {

    public String trainDirectionName;

    public String trainDirectionContent;

    public String certificate;
}
