package com.consult_system.entity;

import com.consult_system.viewmodel.BaseObject;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jacob
 * @date 2020/3/11
 */

@Entity
@Data
@Table(name = "key_word")
public class KeyWord extends BaseObject {
}
