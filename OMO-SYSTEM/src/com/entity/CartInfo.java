package com.entity;

import java.io.Serializable;
/**
 * ���ﳵ�࣬���������ݿ�������Ӧ�ı�
 * @author DaiJinchi
 * 2017-08-20
 */
public class CartInfo implements Serializable{
	private int quantity;//��һ��Ʒ���빺�ﳵ������
	private Meal meal;//��Ʒ
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
