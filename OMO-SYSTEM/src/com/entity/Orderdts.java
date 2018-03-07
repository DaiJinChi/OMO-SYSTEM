package com.entity;

import java.io.Serializable;
/**
 * 订单内容实体类
 * @author DaiJinchi
 * 2017-08-20
 */
public class Orderdts implements Serializable{
	private Integer odid;//id
	private Meal meal;//多对一 菜品
	private Orders orders;//多对一 订单
	private Double mealPrice;// 菜品价格
	private Integer mealCount;//菜品总数
	public Orderdts() {
		super();
	}
	public Orderdts(Integer odid, Meal meal, Orders orders, Double mealPrice,
			Integer mealCount) {
		super();
		this.odid = odid;
		this.meal = meal;
		this.orders = orders;
		this.mealPrice = mealPrice;
		this.mealCount = mealCount;
	}
	public Integer getOdid() {
		return odid;
	}
	public void setOdid(Integer odid) {
		this.odid = odid;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Double getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}
	public Integer getMealCount() {
		return mealCount;
	}
	public void setMealCount(Integer mealCount) {
		this.mealCount = mealCount;
	}
}
