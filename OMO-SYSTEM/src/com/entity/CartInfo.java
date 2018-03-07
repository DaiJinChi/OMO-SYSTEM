package com.entity;

import java.io.Serializable;
/**
 * 购物车类，该类在数据库中无相应的表
 * @author DaiJinchi
 * 2017-08-20
 */
public class CartInfo implements Serializable{
	private int quantity;//单一菜品加入购物车的数量
	private Meal meal;//菜品
	public CartInfo() {
		super();
	}
	public CartInfo(int quantity, Meal meal) {
		super();
		this.quantity = quantity;
		this.meal = meal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
}
