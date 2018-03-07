package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * ����ʵ����
 * @author DaiJinchi
 * 2017-08-20
 */
public class Orders implements Serializable{
	private Integer oid;//����id
	private Users users;//���һ
	private Date orderTime;//����ʱ��
	private String orderState;//�������
	private Double orderPrice;//�����۸�
	private Set orderdtses = new HashSet(0);//һ�Զ�
	public Orders() {
		super();
	}
	public Orders(Integer oid, Users users, Date orderTime, String orderState,
			Double orderPrice, Set orderdtses) {
		super();
		this.oid = oid;
		this.users = users;
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.orderPrice = orderPrice;
		this.orderdtses = orderdtses;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Set getOrderdtses() {
		return orderdtses;
	}
	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}
}
