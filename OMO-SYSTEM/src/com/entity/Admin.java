package com.entity;

import java.io.Serializable;
/**
 * ����Աʵ����
 * @author DaiJinchi
 * 2017-08-20
 */
public class Admin implements Serializable{
	private Integer id;//����Աid
	private String loginName;//����Ա�˺�
	private String loginPwd;//����Ա����
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
