package com.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.MealDao;
import com.entity.CartInfo;
import com.entity.Meal;
/**
 * ���ﳵ��ع��ܿ��Ʋ�
 * @author DaiJinchi
 * 2017-8-24
 */
@Controller
public class CartAction implements SessionAware{
	private Map<String, Object> session;
	private int mealId;//��Ʒid
	private int quantity;//��Ʒ����
	
	@Resource
	private MealDao mealDao;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	//��ӹ��ﳵ��Ϣ
	public String addCart(){
		//session�в�ѯ���ﳵ
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		//���ݲ�Ʒid��ѯ��Ʒ��Ϣ
		Meal meal = mealDao.findById(mealId);
		//session���޹��ﳵʱ����ӹ��ﳵ
		if (cart == null){
			cart = new HashMap<String, CartInfo>();
			session.put("cart", cart);
		}
		CartInfo m = cart.get(mealId+"");
		if (m == null){
			m = new CartInfo(1, meal);
			cart.put(mealId+"", m);
		}else {
			System.out.println("----------------");
			m.setQuantity(m.getQuantity()+1);
			cart.put(mealId+"", m);
		}
		return "success";
	}
	//ɾ�����ﳵ�еĲ�Ʒ
	public String deleteMealInCart(){
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		try {
			cart.remove(mealId+"");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	//��չ��ﳵ
		public String clearCart(){
			Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
			try {
				cart.clear();
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
	//�޸Ĺ��ﳵ��Ʒ����
	public String updateQuantity(){
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		CartInfo ci = cart.get(mealId+"");
		ci.setQuantity(quantity);
		return "success";
	}
	
}
