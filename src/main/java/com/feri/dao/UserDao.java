package com.feri.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.User;

public interface UserDao {

	//新增
	@Insert("insert into t_user(no,password,role,flag) values(#{no},#{password},#{role},1)")
	public int insert(User user);
	//查询
	@Select("select * from t_user where no=#{no} and flag=1 and role>1")
	@ResultType(User.class)
	public User queryByNo(String no);
	//修改密码
	@Update("update t_user set password=#{password} where flag=1 and role>1 and no=#{no}")
	public int updatePassword(User user);
	
}
