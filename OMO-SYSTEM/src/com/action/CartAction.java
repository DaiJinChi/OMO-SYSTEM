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
 * 购物车相关功能控制层
 * @author DaiJinchi
 * 2017-8-24
 */
@Controller
public class CartAction implements SessionAware{
	private Map<String, Object> session;
	private int mealId;//菜品id
	private int quantity;//菜品数量
	
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
	//添加购物车信息
	public String addCart(){
		//session中查询购物车
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		//根据菜品id查询菜品信息
		Meal meal = mealDao.findById(mealId);
		//session中无购物车时，添加购物车
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
	//删除购物车中的菜品
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
	//清空购物车
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
	//修改购物车产品数量
	public String updateQuantity(){
		Map<String, CartInfo> cart = (Map<String, CartInfo>) session.get("cart");
		CartInfo ci = cart.get(mealId+"");
		ci.setQuantity(quantity);
		return "success";
	}
	
}
