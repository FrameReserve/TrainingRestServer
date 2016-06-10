/**
 * 
 */
package com.xxx.training.entity.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.xxx.training.entity.domain.UsersRoles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xxx
 *
 */
@Entity
@Table(name="users")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@XmlRootElement(name="user")
@JsonRootName("user")
public class User {
	@Id
	@Column(name="id",unique = true,length = 36,nullable = false)
	@GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
	@JsonProperty("id")
	private String id;
	@Column(name="proxy_id")
	private Integer proxyId;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="regtime")
	private String regTime;
	@Column(name="logintime")
	private String loginTime;
	@Column(name="qq")
	private Integer qq;
	@Column(name="email")
	private String email;
	@Column(name="tel")
	private String tel;

    @Column(name="qq_au")
	private String qqAu;
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "user")
    private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
	
	//***************************************************

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
	 * @author Lai Zhen Wei
	 * @created 2016-6-2 上午8:36:55 
	 * @return type 
	 */
	
	public Integer getProxyId() {
		return proxyId;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55         
	 * @param proxyId   
	 */
	public void setProxyId(Integer proxyId) {
		this.proxyId = proxyId;
	}
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55 
	 * @return type 
	 */
	
	public String getUsername() {
		return username;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55         
	 * @param username
	 */
	public void setUserName(String username) {
		this.username = username;
	}
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55 
	 * @return type 
	 */
	
	public String getPassword() {
		return password;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55         
	 * @param password   
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:53:57 
	 * @return type 
	 */
	
	public String getRegTime() {
		return regTime;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:53:57         
	 * @param regTime   
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:53:57 
	 * @return type 
	 */
	
	public String getLoginTime() {
		return loginTime;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:53:57         
	 * @param loginTime   
	 */
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55 
	 * @return type 
	 */
	
	public Integer getQq() {
		return qq;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55         
	 * @param qq   
	 */
	public void setQq(Integer qq) {
		this.qq = qq;
	}
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55 
	 * @return type 
	 */
	
	public String getEmail() {
		return email;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55         
	 * @param email   
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55 
	 * @return type 
	 */
	
	public String getTel() {
		return tel;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55         
	 * @param tel   
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**    
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55 
	 * @return type 
	 */
	
	public String getQqAu() {
		return qqAu;
	}
	/**     
	 * @author Lai Zhen Wei       
	 * @created 2016-6-2 上午8:36:55         
	 * @param qqAu   
	 */
	public void setQqAu(String qqAu) {
		this.qqAu = qqAu;
	}

    public Set<UsersRoles> getUsersRoleses() {
        return usersRoleses;
    }

    public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
        this.usersRoleses = usersRoleses;
    }
}
