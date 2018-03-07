package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 菜系实体类
 * @author DaiJinchi
 * 2017-08-20
 */
public class Mealseries implements Serializable{
	private Integer seriesId;//菜系id
	private String seriesName;//菜系名称
	private Set<Meal> meals = new HashSet<Meal>();//一对多
	public Mealseries() {
		super();
	}
	public Mealseries(Integer seriesId, String seriesName, Set<Meal> meals) {
		super();
		this.seriesId = seriesId;
		this.seriesName = seriesName;
		this.meals = meals;
	}
	public Integer getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public Set<Meal> getMeals() {
		return meals;
	}
	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
	}
}
