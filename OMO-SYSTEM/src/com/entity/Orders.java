package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 订单实体类
 * @author DaiJinchi
 * 2017-08-20
 */
public class Orders implements Serializable{
	private Integer oid;//订单id
	private Users users;//多对一
	private Date orderTime;//订单时间
	private String orderState;//订单情况
	private Double orderPrice;//订单价格
	private Set orderdtses = new HashSet(0);//一对多
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
