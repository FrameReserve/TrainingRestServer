package com.training.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable {
	
    @Id
    @Column(name="id",unique = true,length = 36,nullable = false)
    @GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @JsonProperty("id")
    private String id;
    
    /**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后修改时间
	 */
	private Date lastModifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
