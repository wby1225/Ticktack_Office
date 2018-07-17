package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Course;

public interface CourseDao {

	// 新增
	@Insert("insert into t_course(name,createtime,flag,week,type) value(#{name},#{createtime},1,#{week},#{type})")
	int insert(Course course);

	// 修改
	@Update("update t_course set name=#{name} where flag=1 and id=#{id}")
	int update(Course course);

	// 删除
	@Update("update t_course set flag=2 where id=#{id}")
	int delete(int id);

	// 查询 分页
	@Select("select * from t_course where flag=1 limit #{rowindex},#{count}")
	@ResultType(Course.class)
	List<Course> queryByPage(@Param("rowindex") int index, @Param("count") int count);

	// 总数量
	@Select("select count(*) from t_course where flag=1")
	@ResultType(Long.class)
	Long queryCount();

}
