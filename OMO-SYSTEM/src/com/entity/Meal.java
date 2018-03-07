package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * ��Ʒʵ����
 * @author DaiJinchi
 * 2017-08-20
 */
public class Meal implements Serializable{
	private Integer mealId;//��Ʒid
	private Mealseries mealseries;//���һ ��Ʒϵ��
	private String mealName;//��Ʒ����
	private String mealSummarize;//��Ʒ���
	private String mealDescription;//��Ʒ˵��
	private Double mealPrice;//��Ʒ�۸�
	private String mealImage;//��ƷͼƬ
	private Set orderdtses = new HashSet(0);
	public Meal() {
		super();
	}
	public Meal(Integer mealId, Mealseries mealseries, String mealName,
			String mealSummarize, String mealDescription, Double mealPrice,
			String mealImage, Set orderdtses) {
		super();
		this.mealId = mealId;
		this.mealseries = mealseries;
		this.mealName = mealName;
		this.mealSummarize = mealSummarize;
		this.mealDescription = mealDescription;
		this.mealPrice = mealPrice;
		this.mealImage = mealImage;
		this.orderdtses = orderdtses;
	}
	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}
	public Mealseries getMealseries() {
		return mealseries;
	}
	public void setMealseries(Mealseries mealseries) {
		this.mealseries = mealseries;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getMealSummarize() {
		return mealSummarize;
	}
	public void setMealSummarize(String mealSummarize) {
		this.mealSummarize = mealSummarize;
	}
	public String getMealDescription() {
		return mealDescription;
	}
	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}
	public Double getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}
	public String getMealImage() {
		return mealImage;
	}
	public void setMealImage(String mealImage) {
		this.mealImage = mealImage;
	}
	public Set getOrderdtses() {
		return orderdtses;
	}
	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}
}
