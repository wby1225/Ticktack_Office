package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Grade;

public interface GradeDao {
	// 添加班级
	@Insert("insert into t_grade (no,name,createtime,flag,week,location) values (#{no},#{name},#{createtime},1,#{week},#{location})")
	int add(Grade grade);

	// 修改班级
	@Update("update t_grade set name=#{name},week=#{week},location=#{location} where id=#{id}")
	int update(Grade grade);

	// 删除班级
	@Update("update t_grade set flag=2 where id=#{id}")
	int delete(int id);

	// 查询班级
	@Select("select * from t_grade where flag=1 limit #{index},#{count}")
	@ResultType(Grade.class)
	List<Grade> queryAll(@Param("index") int index, @Param("count") int count);

	// 总数量
	@Select("select count(*) from t_grade where flag=1")
	@ResultType(Long.class)
	Long queryCount();

	@Select("select id,name from t_grade")
	@ResultType(Grade.class)
	List<Grade> queryGradeAll();
}
