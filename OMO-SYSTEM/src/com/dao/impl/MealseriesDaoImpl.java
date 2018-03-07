package com.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.dao.MealseriesDao;
import com.entity.Mealseries;
/**
 * ��ϵdao��ʵ�ֲ�
 * @author DaiJinchi
 *	2017-8-20
 */
@Repository
public class MealseriesDaoImpl implements MealseriesDao{
	private SessionFactory sessionFactory;
	//ע��sessionFactory
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//�������в�ϵ
	@Override
	public List<Mealseries> findAllMS() {
		//��ȡsession
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Mealseries";
		Query query = session.createQuery(hql);
		List<Mealseries> list = query.list();
		return list;
	}
}
