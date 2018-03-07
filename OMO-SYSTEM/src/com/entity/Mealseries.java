package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * ��ϵʵ����
 * @author DaiJinchi
 * 2017-08-20
 */
public class Mealseries implements Serializable{
	private Integer seriesId;//��ϵid
	private String seriesName;//��ϵ����
	private Set<Meal> meals = new HashSet<Meal>();//һ�Զ�
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
