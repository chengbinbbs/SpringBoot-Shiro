package com.daysluck.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String username;	//账号
	
	private String name;		//名称
	
	private String password;	//密码
	
	private String salt;		//加密密码的盐
	
	private byte state;			////用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定

	@ManyToMany(fetch = FetchType.EAGER)  ////立即从数据库中进行加载数据;
	@JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name="uid")}, inverseJoinColumns ={@JoinColumn (name="roleId")})
	private List<SysRole> roleList;			//一个用户对应多个角色
	
	
	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}
	
	/**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
       return this.username+this.salt;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", solt="
				+ salt + ", state=" + state + "]";
	}
	
}
