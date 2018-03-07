package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 用户实体类
 * @author DaiJinchi
 * 2017-08-20
 */
public class Users implements Serializable{
	private Integer id;//用户id
	private String loginName;//客户姓名
	private String loginPwd;//客户密码
	private String trueName;//真实姓名
	private String email;//邮箱
	private String phone;//电话
	private String address;//住址
	private Set<Orders> orderses = new HashSet<Orders>();//一对多
	public Users() {
		super();
	}
	public Users(Integer id, String loginName, String loginPwd,
			String trueName, String email, String phone, String address,
			Set<Orders> orderses) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.trueName = trueName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.orderses = orderses;
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
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Orders> getOrderses() {
		return orderses;
	}
	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}
}
