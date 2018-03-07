package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 菜品实体类
 * @author DaiJinchi
 * 2017-08-20
 */
public class Meal implements Serializable{
	private Integer mealId;//菜品id
	private Mealseries mealseries;//多对一 菜品系列
	private String mealName;//菜品名称
	private String mealSummarize;//菜品简介
	private String mealDescription;//菜品说明
	private Double mealPrice;//菜品价格
	private String mealImage;//菜品图片
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
