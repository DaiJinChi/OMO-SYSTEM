package com.entity;

import java.io.Serializable;
/**
 * ��������ʵ����
 * @author DaiJinchi
 * 2017-08-20
 */
public class Orderdts implements Serializable{
	private Integer odid;//id
	private Meal meal;//���һ ��Ʒ
	private Orders orders;//���һ ����
	private Double mealPrice;// ��Ʒ�۸�
	private Integer mealCount;//��Ʒ����
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
