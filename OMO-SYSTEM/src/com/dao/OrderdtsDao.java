package com.dao;

import java.util.List;
import com.entity.Orderdts;
import com.entity.Orders;
/**
 * 订单dao层
 * @author DaiJinchi
 * 2017-08-25
 */
public interface OrderdtsDao {
	//添加订单详情
	public void addOrderdts(Orderdts orderdts);
	//根据用户id查找订单，返回订单的List集合
	public List<Orders> findOrdersByUserId(int id);
	//删除订单
	public void deleteOrders(int id);
	//根据订单id查询详情，返回订单详情的List集合
	public List<Orderdts> findById(int id);
	//查询订单总数
	public int findOrdersAllCount();
	//分页查询订单信息，返回订单的List集合
	public List<Orders> findOrders(int page,int pageSize);
	//根据id处理订单
	public void doOrderById(int id);
	//根据参数分页查找订单，返回订单的List集合
	public List<Orders> findByParam(int page,int pageSize,Orders orders);
	//根据参数查询订单总数
	public int findOrdersCountByParam(Orders orders);
	//根据用户id查询订单总数
	public int findOrdersCountByUserId(int id);
	//根据用户id分页查询订单，返回订单的List集合
	public List<Orders> findOrdersByUserIdForPage(int page,int pageSize,int id);
	
}
