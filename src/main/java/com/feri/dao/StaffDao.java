package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Staff;

public interface StaffDao {

	// 新增
	@Insert("insert into t_staff(no,name,did,sex,qq,phone,email,heading,entrytime,flag) value"
			+ "(#{no},#{name},#{did},#{sex},#{qq},#{phone},#{email},#{heading},#{entrytime},1)")
	int insert(Staff staff);

	// 修改
	@Update("update t_staff set name=#{name},did=#{did},email=#{email},phone=#{phone},qq=#{qq},heading=#{heading} where flag=1 and no=#{no}")
	int update(Staff staff);

	// 删除
	@Update("update t_staff set flag=2 where no=#{no}")
	int delete(String no);

	// 查询 分页
	@Select("select a.*,b.name as dname from t_staff a,t_depart b where a.did=b.id and a.flag=1 limit #{index},#{count}")
	@ResultType(Staff.class)
	List<Staff> queryByPage(@Param("index") int index, @Param("count") int count);

	@Select("select a.*,b.name as dname from t_staff a,t_depart b where a.did=b.id and did=#{did} and a.flag=1 limit #{index},#{count}")
	@ResultType(Staff.class)
	List<Staff> queryByPageByDid(@Param("index") int index, @Param("count") int count, @Param("did") String did);

	// 总数量
	@Select("select count(1) from t_staff a,t_depart b where a.did=b.id and a.flag=1")
	@ResultType(Long.class)
	Long queryCount();

	@Select("select count(1) from t_staff a,t_depart b where a.did=b.id and a.flag=1 and did=#{did}")
	@ResultType(Long.class)
	Long queryCountByDid(String did);

	@Select("select no from t_staff order by no desc limit 1")
	@ResultType(String.class)
	String queryMaxNo();
}
