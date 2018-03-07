package com.dao;

import java.util.List;

import com.entity.Admin;
import com.entity.Users;
/**
 * 用户dao层
 * @author DaiJinchi
 *	2017-08-24
 */
public interface UserDao {
	//新增用户
	public boolean addUser(Users user);
	//检查用户登录，返回用户的List集合
	public List<Users> checkUser(Users user);
	//检查管理员，返回管理员的List集合
	public List<Admin> checkAdmin(Admin admin);
	//修改用户信息
	public boolean updateUser(Users user);
}
