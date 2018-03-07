package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dao.OrderdtsDao;
import com.entity.Meal;
import com.entity.Orderdts;
import com.entity.Orders;
/**
 * 订单dao层实现层
 * @author DaiJinchi
 * 2017-08-25
 */
@Repository
public class OderdtsDaoImpl implements OrderdtsDao{
	private SessionFactory sessionFactory;
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//添加订单详情
	@Override
	public void addOrderdts(Orderdts orderdts) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderdts);
	}
	//根据用户id查找订单
	@Override
	public List<Orders> findOrdersByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("users.id", id));
		List<Orders> list = criteria.list();
		return list;
	}
	//删除订单
	@Override
	public void deleteOrders(int id) {
		Session session = sessionFactory.getCurrentSession();
		//根据ID查询订单
		Orders orders = (Orders)session.get(Orders.class, id);
		session.delete(orders);
	}
	//根据订单id查询详情
	@Override
	public List<Orderdts> findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orderdts.class);
		criteria.add(Restrictions.eq("orders.oid", id));
		List<Orderdts> list = criteria.list();
		return list;
	}
	//查询订单总数
	@Override
	public int findOrdersAllCount() {
		int i = 0;
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(m) from Orders m";
		Query query = session.createQuery(hql);
		i = Integer.valueOf(query.uniqueResult().toString());
		return i;
	}
	//分页查询订单信息
	@Override
	public List<Orders> findOrders(int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.setFirstResult((page-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	//根据id处理订单
	@Override
	public void doOrderById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Orders order = (Orders)session.get(Orders.class, id);
		order.setOrderState("已处理");
		session.update(order);
	}
	//根据参数分页查找订单
	@Override
	public List<Orders> findByParam(int page, int pageSize, Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		if (orders.getOrderState() != null && !orders.getOrderState().equals("")){
			criteria.add(Restrictions.eq("orderState", orders.getOrderState()));
		}
		if (orders.getOid() != null && !orders.getOid().equals("")){
			criteria.add(Restrictions.like("oid", orders.getOid()));
		}
		criteria.setFirstResult((page-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	//根据参数查询订单数量
	@Override
	public int findOrdersCountByParam(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		if (orders.getOrderState() != null && !orders.getOrderState().equals("")){
			//模糊查询
			criteria.add(Restrictions.like("orderState", orders.getOrderState(), MatchMode.ANYWHERE));
		}
		if (orders.getOid() != null && !orders.getOid().equals("")){
			criteria.add(Restrictions.like("oid", orders.getOid()));
		}
		return criteria.list().size();
	}
	//根据用户id查询订单总数
	@Override
	public int findOrdersCountByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("users.id", id));
		return criteria.list().size();
	}
	//根据用户id分页查询订单
	@Override
	public List<Orders> findOrdersByUserIdForPage(int page, int pageSize, int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("users.id", id));
		criteria.setFirstResult((page-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}

}
