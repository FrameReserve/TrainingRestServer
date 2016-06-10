package com.xxx.training.entity.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by xxx on 2016-06-04.
 */

@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@XmlRootElement(name="usersRoles")
@JsonRootName("usersRoles")
@Entity
@Table(name="users_roles")
public class UsersRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    public UsersRoles(){}
    @Id
    @Column(name="urId",unique = true,length = 36,nullable = false)
    @GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @JsonProperty("urId")
    private String urId;
    @JsonProperty("roles")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rid")
    private Roles roles;
    @JsonProperty("users")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uid")
    private User user;

    public String getUrId() {
        return urId;
    }

    public void setUrId(String urId) {
        this.urId = urId;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
