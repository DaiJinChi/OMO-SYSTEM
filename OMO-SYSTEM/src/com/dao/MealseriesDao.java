package com.dao;

import java.util.List;
import com.entity.Mealseries;
/**
 * ��ϵdao��
 * @author DaiJinchi
 *	2017-8-20
 */
public interface MealseriesDao {
	//��ѯ���в�ϵ�����ز�ϵ��List����
	public List<Mealseries> findAllMS();
}
