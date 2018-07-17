package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.feri.domain.Student;

public interface StudentDao {

	// 新增
	@Insert("insert into t_student(no,name,sex,birthday,cardno,schoolname,education,phone,email,qq,cno,introno,flag,entrytime) value"
			+ "(#{no},#{name},#{sex},#{birthday},#{cardno},#{schoolname},#{education},#{phone},#{email},#{qq},#{cno},#{introno},1,#{entrytime})")
	int insert(Student student);

	// 修改
	@Update("update t_student set name=#{name} where flag=1 and id=#{id}")
	int update(@Param("name") String name, @Param("id") int id);

	// 删除
	@Update("update t_student set flag=2 where id=#{id}")
	int delete(int id);

	// 查询 分页
	@Select("select a.*,b.name as gname from t_student a,t_grade b where a.cno=b.id and a.flag=1 limit #{index},#{count}")
	@ResultType(Student.class)
	List<Student> queryByPage(@Param("index") int index, @Param("count") int count);

	// 查询 分页
	@Select("select a.*,b.name as gname from t_student a,t_grade b where a.cno=b.id and a.flag=1 and  a.cno=#{cno} limit #{index},#{count}")
	@ResultType(Student.class)
	List<Student> queryByPageByCno(@Param("index") int index, @Param("count") int count, @Param("cno") String cno);

	// 总数量
	@Select("select count(*) from t_student where flag=1")
	@ResultType(Long.class)
	Long queryCount();

	@Select("select count(*) from t_student where flag=1 and cno=#{cno}")
	@ResultType(Long.class)
	Long queryCountByCno(String cno);

	@Select("select a.*,b.name as gname from t_student a,t_grade b where a.cno=b.id and a.no=#{no}")
	@ResultType(Student.class)
	Student queryByNo(String no);

	@Select("select name from t_student where cno=#{cno} and flag=1")
	@ResultType(Student.class)
	List<Student> queryByCno(String cno);
}
