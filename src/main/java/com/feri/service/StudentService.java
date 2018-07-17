package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Student;

public interface StudentService {
	ResultVo insert(Student student);

	// 修改
	ResultVo update(String name, int id);

	// 删除
	ResultVo delete(int id);

	// 查询 分页
	PageVo<Student> queryByPage(int page, int count);
	PageVo<Student> queryByPageByCno(int page, int count, String cno);

	// 总数量
	Long queryCount();

	boolean insertBatch(List<Student> list);

	Student queryByNo(String no);

	PageVo<Student> queryByCno(String cno);
}
