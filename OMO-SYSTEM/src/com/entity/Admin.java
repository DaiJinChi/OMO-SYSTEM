package com.entity;

import java.io.Serializable;
/**
 * 管理员实体类
 * @author DaiJinchi
 * 2017-08-20
 */
public class Admin implements Serializable{
	private Integer id;//管理员id
	private String loginName;//管理员账号
	private String loginPwd;//管理员密码
	public Admin() {
		super();
	}
	public Admin(Integer id, String loginName, String loginPwd) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
}
