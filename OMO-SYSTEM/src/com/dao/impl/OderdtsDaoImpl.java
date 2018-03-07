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
 * ����dao��ʵ�ֲ�
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
	//��Ӷ�������
	@Override
	public void addOrderdts(Orderdts orderdts) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderdts);
	}
	//�����û�id���Ҷ���
	@Override
	public List<Orders> findOrdersByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("users.id", id));
		List<Orders> list = criteria.list();
		return list;
	}
	//ɾ������
	@Override
	public void deleteOrders(int id) {
		Session session = sessionFactory.getCurrentSession();
		//����ID��ѯ����
		Orders orders = (Orders)session.get(Orders.class, id);
		session.delete(orders);
	}
	//���ݶ���id��ѯ����
	@Override
	public List<Orderdts> findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orderdts.class);
		criteria.add(Restrictions.eq("orders.oid", id));
		List<Orderdts> list = criteria.list();
		return list;
	}
	//��ѯ��������
	@Override
	public int findOrdersAllCount() {
		int i = 0;
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(m) from Orders m";
		Query query = session.createQuery(hql);
		i = Integer.valueOf(query.uniqueResult().toString());
		return i;
	}
	//��ҳ��ѯ������Ϣ
	@Override
	public List<Orders> findOrders(int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.setFirstResult((page-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	//����id������
	@Override
	public void doOrderById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Orders order = (Orders)session.get(Orders.class, id);
		order.setOrderState("�Ѵ���");
		session.update(order);
	}
	//���ݲ�����ҳ���Ҷ���
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
	//���ݲ�����ѯ��������
	@Override
	public int findOrdersCountByParam(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		if (orders.getOrderState() != null && !orders.getOrderState().equals("")){
			//ģ����ѯ
			criteria.add(Restrictions.like("orderState", orders.getOrderState(), MatchMode.ANYWHERE));
		}
		if (orders.getOid() != null && !orders.getOid().equals("")){
			criteria.add(Restrictions.like("oid", orders.getOid()));
		}
		return criteria.list().size();
	}
	//�����û�id��ѯ��������
	@Override
	public int findOrdersCountByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("users.id", id));
		return criteria.list().size();
	}
	//�����û�id��ҳ��ѯ����
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
