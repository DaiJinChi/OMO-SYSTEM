package com.dao;

import java.util.List;
import com.entity.Orderdts;
import com.entity.Orders;
/**
 * ����dao��
 * @author DaiJinchi
 * 2017-08-25
 */
public interface OrderdtsDao {
	//��Ӷ�������
	public void addOrderdts(Orderdts orderdts);
	//�����û�id���Ҷ��������ض�����List����
	public List<Orders> findOrdersByUserId(int id);
	//ɾ������
	public void deleteOrders(int id);
	//���ݶ���id��ѯ���飬���ض��������List����
	public List<Orderdts> findById(int id);
	//��ѯ��������
	public int findOrdersAllCount();
	//��ҳ��ѯ������Ϣ�����ض�����List����
	public List<Orders> findOrders(int page,int pageSize);
	//����id������
	public void doOrderById(int id);
	//���ݲ�����ҳ���Ҷ��������ض�����List����
	public List<Orders> findByParam(int page,int pageSize,Orders orders);
	//���ݲ�����ѯ��������
	public int findOrdersCountByParam(Orders orders);
	//�����û�id��ѯ��������
	public int findOrdersCountByUserId(int id);
	//�����û�id��ҳ��ѯ���������ض�����List����
	public List<Orders> findOrdersByUserIdForPage(int page,int pageSize,int id);
	
}
