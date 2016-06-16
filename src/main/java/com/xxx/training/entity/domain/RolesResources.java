package com.xxx.training.entity.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.xxx.training.core.entity.BaseEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xxx on 2016-06-04.
 */
@Entity
@Table(name="roles_resources")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@XmlRootElement(name="rolesResources")
@JsonRootName("rolesResources")
public class RolesResources extends BaseEntity{
    private static final long serialVersionUID = 1L;
    public RolesResources(){}
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rid")
    private Roles roles;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rsid")
    private Resources resources;

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
