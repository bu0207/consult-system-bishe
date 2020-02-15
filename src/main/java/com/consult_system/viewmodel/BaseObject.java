package com.consult_system.viewmodel;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jacob
 * @date 2019/12/30
 * @description entity父类
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract  class BaseObject implements Serializable{

	public BaseObject() {
	}
	
	public BaseObject(Integer keyId) {
        this.keyId = keyId;
    }
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer keyId;

    /**
     * 创建时间,(旧版)
     */
//    @Temporal(TemporalType.TIMESTAMP)
//    protected Date latestTime;
    
    /**
     * 创建时间(新版)
     */
    @CreatedDate
    protected Date createTime;

    /**
     * 更新时间
     */
    @LastModifiedDate
    protected Date updateTime;

    /**
     * 是否删除
     */
    @Column(columnDefinition = "int default 0")
    protected Integer isDeleted = 0;
    
    public Integer getKeyId() {
		return keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
