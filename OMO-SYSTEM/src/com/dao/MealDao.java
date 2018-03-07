package com.dao;

import java.util.List;
import com.entity.Meal;
/**
 * 菜品dao层
 * @author DaiJinchi
 *	2017-08-25
 */
public interface MealDao {
	//查询菜品总数
	public int findAllCount();
	//分页查询菜品信息，返回菜品的List集合
	public List<Meal> findAllMeal(int page,int pageSize);
	//根据条件查询菜品信息，返回菜品的List集合
	public List<Meal> findByParam(int page,int pageSize,Meal meal);
	//根据条件查询菜品总数
	public int findCountByparam(Meal meal);
	//根据id查询菜品信息，返回菜品
	public Meal findById(int id);
	//新增菜品
	public void addMeal(Meal meal);
	//修改菜品信息
	public void updateMeal(Meal meal);
	//根据id删除菜品
	public void deleteMeal(int mealId);
}
