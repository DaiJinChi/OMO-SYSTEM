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
 * 用户dao层实现层
 * @author DaiJinchi
 *	2017-08-24
 */
@Repository
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;
	
	//注入sessionFactory
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//新增用户
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
	//检查用户登录
	@Override
	public List<Users> checkUser(Users user) {
		List<Users> list = null;
		//创建session对象
		Session session = sessionFactory.getCurrentSession();
		//创建createCriteria对象
		Criteria c = session.createCriteria(Users.class);
		Example e = Example.create(user);
		c.add(e);
		list = c.list();
		return list;
	}
	//检查管理员登录
	@Override
	public List<Admin> checkAdmin(Admin admin) {
		List<Admin> list = null;
		//创建session对象
		Session session = sessionFactory.getCurrentSession();
		//创建createCriteria对象
		Criteria c = session.createCriteria(Admin.class);
		Example e = Example.create(admin);
		c.add(e);
		list = c.list();
		return list;
	}
	//修改用户信息
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
