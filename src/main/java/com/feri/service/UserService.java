package com.feri.service;

import java.util.List;

import com.feri.domain.User;

public interface UserService {

	//登录
	public User queryByNo(String no,String password);
	//修改密码
	public boolean updatePassword(User user);
	//新增
	public boolean insert(User user);
	//批量新增
	public boolean insertBach(List<User> list);
}
