package com.feri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.StudentDao;
import com.feri.domain.Student;
import com.feri.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao dao;

	@Override
	public ResultVo insert(Student student) {

		if (dao.insert(student) > 0) {
			return ResultVo.setOK("添加学生成功");
		} else {
			return ResultVo.setERROR("添加学生失败");
		}

	}

	@Override
	public ResultVo update(String name, int id) {
		if (dao.update(name, id) > 0) {
			return ResultVo.setOK("修改学生成功");
		} else {
			return ResultVo.setERROR("修改学生失败");
		}
	}

	@Override
	public ResultVo delete(int id) {
		if (dao.delete(id) > 0) {
			return ResultVo.setOK("删除学生成功");
		} else {
			return ResultVo.setERROR("删除学生失败");
		}
	}

	@Override
	public PageVo<Student> queryByPage(int page, int count) {
		PageVo<Student> vo = new PageVo<>();
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		List<Student> list = dao.queryByPage(index, count);
		if (list != null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(dao.queryCount().intValue());
		} else {
			vo.setCode(1);
			vo.setMsg("暂无数据");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}

	@Override
	public PageVo<Student> queryByPageByCno(int page, int count, String cno) {
		PageVo<Student> vo = new PageVo<>();
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		List<Student> list = dao.queryByPageByCno(index, count, cno);
		if (list != null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(dao.queryCountByCno(cno).intValue());
		} else {
			vo.setCode(1);
			vo.setMsg("暂无数据");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}

	@Override
	public Long queryCount() {

		return dao.queryCount();
	}

	@Override
	public boolean insertBatch(List<Student> list) {
		// TODO Auto-generated method stub
		try {
			for (Student s : list) {
				dao.insert(s);
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Student queryByNo(String no) {

		return dao.queryByNo(no);
	}

	@Override
	public PageVo<Student> queryByCno(String cno) {
		PageVo<Student> vo = new PageVo<>();
		List<Student> list = dao.queryByCno(cno);
		if (list != null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(0);
		} else {
			vo.setCode(1);
			vo.setMsg("暂无数据");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}
}
