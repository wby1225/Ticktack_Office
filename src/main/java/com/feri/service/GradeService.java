package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Grade;

public interface GradeService {
	ResultVo add(Grade grade);

	// 修改班级
	ResultVo update(Grade grade);

	// 删除班级
	ResultVo delete(int id);

	// 查询班级
	PageVo<Grade> queryAll(int page, int count);

	List<Grade> queryGradeAll();
}
