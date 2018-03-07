package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.Admin;
import com.entity.Users;
/**
 * �û�dao��ʵ�ֲ�
 * @author DaiJinchi
 *	2017-08-24
 */
@Repository
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;
	
	//ע��sessionFactory
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//�����û�
	@Override
	public boolean addUser(Users user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//����û���¼
	@Override
	public List<Users> checkUser(Users user) {
		List<Users> list = null;
		//����session����
		Session session = sessionFactory.getCurrentSession();
		//����createCriteria����
		Criteria c = session.createCriteria(Users.class);
		Example e = Example.create(user);
		c.add(e);
		list = c.list();
		return list;
	}
	//������Ա��¼
	@Override
	public List<Admin> checkAdmin(Admin admin) {
		List<Admin> list = null;
		//����session����
		Session session = sessionFactory.getCurrentSession();
		//����createCriteria����
		Criteria c = session.createCriteria(Admin.class);
		Example e = Example.create(admin);
		c.add(e);
		list = c.list();
		return list;
	}
	//�޸��û���Ϣ
	@Override
	public boolean updateUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
