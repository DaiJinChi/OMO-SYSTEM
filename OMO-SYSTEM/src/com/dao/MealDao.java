package com.dao;

import java.util.List;
import com.entity.Meal;
/**
 * ��Ʒdao��
 * @author DaiJinchi
 *	2017-08-25
 */
public interface MealDao {
	//��ѯ��Ʒ����
	public int findAllCount();
	//��ҳ��ѯ��Ʒ��Ϣ�����ز�Ʒ��List����
	public List<Meal> findAllMeal(int page,int pageSize);
	//����������ѯ��Ʒ��Ϣ�����ز�Ʒ��List����
	public List<Meal> findByParam(int page,int pageSize,Meal meal);
	//����������ѯ��Ʒ����
	public int findCountByparam(Meal meal);
	//����id��ѯ��Ʒ��Ϣ�����ز�Ʒ
	public Meal findById(int id);
	//������Ʒ
	public void addMeal(Meal meal);
	//�޸Ĳ�Ʒ��Ϣ
	public void updateMeal(Meal meal);
	//����idɾ����Ʒ
	public void deleteMeal(int mealId);
}
