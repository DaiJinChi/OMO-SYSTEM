package com.dao;

import java.util.List;
import com.entity.Mealseries;
/**
 * 菜系dao层
 * @author DaiJinchi
 *	2017-8-20
 */
public interface MealseriesDao {
	//查询所有菜系，返回菜系的List集合
	public List<Mealseries> findAllMS();
}
