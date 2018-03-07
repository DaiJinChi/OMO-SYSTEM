package com.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.OrderdtsDao;
import com.entity.CartInfo;
import com.entity.Orderdts;
import com.entity.Orders;
import com.entity.Users;
/**
 * ������û��͹���Ա�������붩����ص����й���
 * @author DaiJinchi
 * 2017-08-22
 */
@Controller
public class OrdersAction implements SessionAware{
	private Map<String, Object> session;
	private Integer oid;//����id
	private List<Orders> ordersList;
	private int totalPage;
	private int page;
	private int pageSize;
	private int totalNum;
	private Orders orders;
	
	@Resource
	private OrderdtsDao orderdtsDao;
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}

	//���ɶ���
	public String addOrders(){
		Orders orders = new Orders();
		orders.setOrderState("δ����");
		orders.setOrderPrice((Double)session.get("sumPrice"));
		orders.setOrderTime(new Date());
		orders.setUsers((Users)session.get("user"));
		Map<String, CartInfo> cart = (Map<String, CartInfo>)session.get("cart");
		Iterator it = cart.keySet().iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			CartInfo ci = (CartInfo)cart.get(key);
			Orderdts orderdts = new Orderdts();
			orderdts.setMeal(ci.getMeal());
			orderdts.setMealPrice(ci.getMeal().getMealPrice());
			orderdts.setOrders(orders);
			orderdts.setMealCount(ci.getQuantity());
			orderdtsDao.addOrderdts(orderdts);
		}
		session.remove("cart");
		return "success";
	}
	
	//�����û�id��ҳ��ѯ����
	public String findOrders(){
		Users user = (Users) session.get("user");
		int id = user.getId();
		
		totalNum = orderdtsDao.findOrdersCountByUserId(id);
		if (totalNum % pageSize == 0){
			totalPage = totalNum/pageSize;
		}else {
			totalPage = totalNum/pageSize + 1;
		}
		if (page<1){
			page = 1;
		}else if (page > totalPage){
			page = totalPage;
		}
		List<Orders> orders = orderdtsDao.findOrdersByUserIdForPage(page, pageSize, id);
		session.put("orders", orders);
		return "success";
	}
	//ɾ������
	public String deleteOrders(){
		orderdtsDao.deleteOrders(oid);
		return "success";
	}
	//�鿴��������
	public String orderDetail(){
		List<Orderdts> list = orderdtsDao.findById(oid);
		session.put("orderdts", list);
		return "success";
	}
	//��ҳ��ѯ����
	public String findAllOrders(){
		totalNum = orderdtsDao.findOrdersAllCount();
		if (totalNum % pageSize == 0){
			totalPage = totalNum/pageSize;
		}else {
			totalPage = totalNum/pageSize + 1;
		}
		if (page<1){
			page = 1;
		}else if (page > totalPage){
			page = totalPage;
		}
		ordersList = orderdtsDao.findOrders(page, pageSize);
		return "success";
	}
	//������
	public String doOrder(){
		orderdtsDao.doOrderById(oid);
		return "success";
	}
	//���ݲ�����ҳ���Ҷ���
	public String findOrdersByParam(){
		if (orders.getOrderState().equals("ȫ��")){
			orders.setOrderState("");
		}
		totalNum = orderdtsDao.findOrdersCountByParam(orders);
		if (totalNum % pageSize == 0){
			totalPage = totalNum/pageSize;
		}else {
			totalPage = totalNum/pageSize + 1;
		}
		if (page<1){
			page = 1;
		}else if (page > totalPage){
			page = totalPage;
		}
		ordersList = orderdtsDao.findByParam(page, pageSize, orders);
		return "success";
	}
	
}
