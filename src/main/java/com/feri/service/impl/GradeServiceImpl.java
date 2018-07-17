package com.feri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.GradeDao;
import com.feri.domain.Grade;
import com.feri.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	GradeDao dao;

	@Override
	public ResultVo add(Grade grade) {
		if (dao.add(grade) > 0) {
			return ResultVo.setOK("新增班级成功");
		} else {
			return ResultVo.setERROR("新增班级失败");
		}
	}

	@Override
	public ResultVo update(Grade grade) {
		if (dao.update(grade) > 0) {
			return ResultVo.setOK("修改班级成功");
		} else {
			return ResultVo.setERROR("修改班级失败");
		}
	}

	@Override
	public ResultVo delete(int id) {
		if (dao.delete(id) > 0) {
			return ResultVo.setOK("删除班级成功");
		} else {
			return ResultVo.setERROR("删除班级失败");
		}
	}

	@Override
	public PageVo<Grade> queryAll(int page,int count) {
		PageVo<Grade> vo=new PageVo<>();
		int index=0;
		if(page>0) {
			index=(page-1)*count;
		}
		List<Grade> list=dao.queryAll(index, count);
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
	public List<Grade> queryGradeAll() {
		// TODO Auto-generated method stub
		return dao.queryGradeAll();
	}

}
