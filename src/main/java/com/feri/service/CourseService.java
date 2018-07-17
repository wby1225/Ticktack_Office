package com.feri.service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Course;

public interface CourseService {

	// 新增
	ResultVo insert(Course course);

	ResultVo update(Course course);

	ResultVo delete(int id);

	PageVo<Course> queryByPage(int page, int count);

	Long queryCount(int index, int count);


}
