package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Depart;

public interface DepartDao {

	// 新增
	@Insert("insert into t_depart(name,createtime,num,flag) value(#{name},#{createtime},1,1)")
	int insert(Depart depart);

	// 修改
	@Update("update t_depart set name=#{name} where flag=1 and id=#{id}")
	int update(@Param("name") String name, @Param("id") int id);

	// 部门人数增加
	@Update("update t_depart set num=num+1 where flag=1 and id=#{id}")
	int add(int id);

	// 部门人数减少
	@Update("update t_depart set num=num-1 where flag=1 and id=#{id}")
	int dec(int id);

	// 删除
	@Update("update t_depart set flag=2 where id=#{id}")
	int delete(int id);

	// 查询 分页
	@Select("select * from t_depart where flag=1 limit #{rowindex},#{count}")
	@ResultType(Depart.class)
	List<Depart> queryByPage(@Param("rowindex") int index, @Param("count") int count);

	// 总数量
	@Select("select count(*) from t_depart where flag=1")
	@ResultType(Long.class)
	Long queryCount();

	@Select("select * from t_depart where flag=1")
	@ResultType(Depart.class)
	List<Depart> queryAll();

}
