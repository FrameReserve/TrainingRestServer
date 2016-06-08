/**
 * 
 */
package com.xxx.training.entity.domain;

import com.xxx.training.entity.domain.RolesResources;
import com.xxx.training.entity.domain.UsersRoles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xxx
 *
 */
@Entity
@Table(name="roles")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@XmlRootElement(name="role")
@JsonRootName("role")
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;


    public Roles(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name="id")
    private Integer id;
    @Column(name="enable")
    @JsonProperty("enable")
    private Integer enable;
    @Column(name="name")
    @JsonProperty("name")
    private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
    @JsonProperty("usersRoleses")
    private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
    @JsonProperty("rolesResourceses")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<RolesResources> rolesResourceses = new HashSet<RolesResources>(0);
    @JsonProperty("userName")
    @Column(name = "username")
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Set<UsersRoles> getUsersRoleses() {
        return usersRoleses;
    }

    public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
        this.usersRoleses = usersRoleses;
    }

    public Set<RolesResources> getRolesResourceses() {
        return rolesResourceses;
    }

    public void setRolesResourceses(Set<RolesResources> rolesResourceses) {
        this.rolesResourceses = rolesResourceses;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
