package com.xxx.training.entity.domain;

import com.xxx.training.entity.domain.RolesResources;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xxx on 2016-06-04.
 */
@Entity
@Table(name="resources")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@XmlRootElement(name="resources")
@JsonRootName("resources")
public class Resources implements Serializable {
    
		/**  描述   (@author: Lai Zhen Wei) */      
	    
	private static final long serialVersionUID = 1L;

	public  Resources(){}
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="memo")
    @JsonProperty("memo")
    private String memo;
    @Column(name="url")
    @JsonProperty("url")
    private String url;
    @Column(name="priority")
    @JsonProperty("priority")
    private Integer priority;
    @Column(name="type")
    @JsonProperty("type")
    private Integer type;
    @Column(name="name")
    @JsonProperty("name")
    private String name;
    @JsonProperty("RolesResources")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "resources")
    private Set<RolesResources> rolesResourceses = new HashSet<RolesResources>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RolesResources> getRolesResourceses() {
        return rolesResourceses;
    }

    public void setRolesResourceses(Set<RolesResources> rolesResourceses) {
        this.rolesResourceses = rolesResourceses;
    }
}
