package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.feri.domain.Loginlog;

public interface LoginlogDao {
	@Insert("insert into t_loginlog (ip,location,no,createtime) values (#{ip},#{location},#{no},now())")
	public int loginlogAdd(Loginlog loginlog);

	@Select("select * from t_loginlog limit #{index},#{count}")
	@ResultType(Loginlog.class)
	public List<Loginlog> queryAll(@Param("index") int index, @Param("count") int count);

	
	@Select("select count(*) from t_loginlog")
	@ResultType(Long.class)
	Long queryCount();
}
