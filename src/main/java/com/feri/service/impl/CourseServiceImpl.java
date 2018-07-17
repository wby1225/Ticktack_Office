package com.feri.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.CourseDao;
import com.feri.domain.Course;
import com.feri.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao dao;
	@Override
	public ResultVo insert(Course course) {
		if( dao.insert(course)>0) {
			return ResultVo.setOK("新增学科成功");
		}else {
			return ResultVo.setERROR("新增学科失败");
		}
	}

	@Override
	public ResultVo update(Course course) {
		if( dao.update(course)>0) {
			return ResultVo.setOK("修改学科成功");
		}else {
			return ResultVo.setERROR("修改学科失败");
		}
	}

	@Override
	public ResultVo delete(int id) {
		// TODO Auto-generated method stub
		if(dao.delete(id)>0) {
			return ResultVo.setOK("删除学科成功");
		}else {
			return ResultVo.setERROR("删除学科失败");
		}
	}

	@Override
	public PageVo<Course> queryByPage(int page, int count) {
		PageVo<Course> vo=new PageVo<>();
		int index=0;
		if(page>0) {
			index=(page-1)*count;
		}
		List<Course> list=dao.queryByPage(index, count);
		if(list!=null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(dao.queryCount().intValue());
		}else {
			vo.setCode(1);
			vo.setMsg("暂无数据");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}

	@Override
	public Long queryCount(int index, int count) {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}



}
