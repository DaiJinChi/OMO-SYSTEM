package com.dao;

import java.util.List;

import com.entity.Admin;
import com.entity.Users;
/**
 * �û�dao��
 * @author DaiJinchi
 *	2017-08-24
 */
public interface UserDao {
	//�����û�
	public boolean addUser(Users user);
	//����û���¼�������û���List����
	public List<Users> checkUser(Users user);
	//������Ա�����ع���Ա��List����
	public List<Admin> checkAdmin(Admin admin);
	//�޸��û���Ϣ
	public boolean updateUser(Users user);
}
