package com.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.dao.UserDao;
import com.entity.Admin;
import com.entity.Users;

/**
 * �û���Ϣ��ز����Լ��û��͹���Ա�ĵ�¼
 * @author DaiJinchi
 *	2017-8-21
 */
@Controller
public class UserAction implements SessionAware{
	private Users user;
	private Admin admin;
	private Map<String, Object> session;
	private String msg;//��¼��Ϣ����ʱ���ص���Ϣ
	private String role;//��¼��Ϣ����ʱ�������¼���ͣ��û������Ա��¼��
	
	@Resource
	private UserDao userDao;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	//�����û�
	public String addUser(){
		boolean flag = userDao.addUser(user);
		if (flag){
			return "success";
		}
		else {
			return "error";
		}
	}
	//�û���¼��֤
	public String checkUser(){
		List<Users> list = userDao.checkUser(user);
		if (list.size() > 0){
			session.put("user", list.get(0));
			return "success";
		}
		else{
			role = "user";
			msg = "�û������������";
			return "error";
		}
	}
	//����Ա��¼��֤
	public String checkAdmin(){
		List<Admin> list = userDao.checkAdmin(admin);
		if (list.size() > 0){
			session.put("admin", list.get(0));
			return "success";
		}else{
			role = "admin";
			msg = "�û������������";
			return "error";
		}
	}
	//�޸��û���Ϣ
	public String updateUser(){
		boolean flag = userDao.updateUser(user);
		if (flag){
			session.put("user", user);
			return "success";
		}else{
			return "error";
		}
	}
	//ע��
	public String logout(){
		try {
			session.clear();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
