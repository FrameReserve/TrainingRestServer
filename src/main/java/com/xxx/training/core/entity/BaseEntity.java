package com.xxx.training.core.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @Column(name="id",unique = true,length = 36,nullable = false)
    @GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @JsonProperty("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
