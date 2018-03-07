package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * �û�ʵ����
 * @author DaiJinchi
 * 2017-08-20
 */
public class Users implements Serializable{
	private Integer id;//�û�id
	private String loginName;//�ͻ�����
	private String loginPwd;//�ͻ�����
	private String trueName;//��ʵ����
	private String email;//����
	private String phone;//�绰
	private String address;//סַ
	private Set<Orders> orderses = new HashSet<Orders>();//һ�Զ�
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
