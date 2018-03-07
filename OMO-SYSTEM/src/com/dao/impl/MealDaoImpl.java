package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.dao.MealDao;
import com.entity.Meal;
/**
 * ��Ʒdao��ʵ�ֲ�
 * @author DaiJinchi
 *	2017-08-25
 */
@Repository
public class MealDaoImpl implements MealDao{
	private SessionFactory sessionFactory;
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//��ȡ��Ʒ������
	@Override
	public int findAllCount() {
		int i = 0;
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(m) from Meal m";
		Query query = session.createQuery(hql);
		i = Integer.valueOf(query.uniqueResult().toString());
		return i;
	}
	//��ҳ��ѯ��Ʒ
	@Override
	public List<Meal> findAllMeal(int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Meal.class);
		criteria.setFirstResult((page-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	//����������ѯ��Ʒ��Ϣ
	@Override
	public List<Meal> findByParam(int page,int pageSize,Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Meal.class);
		if (meal.getMealName() != null && !meal.getMealName().equals("")){
			//ģ����ѯ
			criteria.add(Restrictions.like("mealName", meal.getMealName(), MatchMode.ANYWHERE));
		}
		if (meal.getMealseries() != null && !meal.getMealseries().equals("")){
			criteria.add(Restrictions.like("mealseries.seriesId", meal.getMealseries().getSeriesId()));
		}
		criteria.setFirstResult((page-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	//����������ѯ��Ʒ����
	@Override
	public int findCountByparam(Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Meal.class);
		if (meal.getMealName() != null && !meal.getMealName().equals("")){
			//ģ����ѯ
			criteria.add(Restrictions.like("mealName", meal.getMealName(), MatchMode.ANYWHERE));
		}
		if (meal.getMealseries() != null && !meal.getMealseries().equals("")){
			criteria.add(Restrictions.like("mealseries.seriesId", meal.getMealseries().getSeriesId()));
		}
		return criteria.list().size();
	}
	//����id��ѯ��Ʒ��Ϣ
	@Override
	public Meal findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Meal meal = (Meal)session.get(Meal.class, id);
		return meal;
	}
	//������Ʒ
	@Override
	public void addMeal(Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		session.save(meal);
	}
	//�޸Ĳ�Ʒ
	@Override
	public void updateMeal(Meal meal) {
		Session session = sessionFactory.getCurrentSession();
		session.update(meal);
	}
	//����idɾ����Ʒ
	@Override
	public void deleteMeal(int mealId) {
		Session session = sessionFactory.getCurrentSession();
		Meal meal = (Meal)session.get(Meal.class, mealId);
		session.delete(meal);
	}
	
}
