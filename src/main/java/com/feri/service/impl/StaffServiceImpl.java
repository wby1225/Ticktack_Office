package com.feri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.DepartDao;
import com.feri.dao.StaffDao;
import com.feri.domain.Staff;
import com.feri.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	StaffDao dao;

	@Autowired
	DepartDao departDao;

	@Override
	public ResultVo insert(Staff staff) {

		if (dao.insert(staff) > 0 && departDao.add(Integer.parseInt(staff.getDid())) > 0) {
			return ResultVo.setOK("添加员工成功");
		} else {
			return ResultVo.setERROR("添加员工失败");
		}

	}

	@Override
	public ResultVo update(Staff staff) {
		if (dao.update(staff) > 0) {
			return ResultVo.setOK("修改员工成功");
		} else {
			return ResultVo.setERROR("修改员工失败");
		}
	}

	@Override
	public ResultVo delete(String no) {
		if (dao.delete(no) > 0) {
			return ResultVo.setOK("删除员工成功");
		} else {
			return ResultVo.setERROR("删除员工失败");
		}
	}

	@Override
	public PageVo<Staff> queryByPage(int page, int count) {
		PageVo<Staff> vo = new PageVo<>();
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		List<Staff> list = dao.queryByPage(index, count);
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
	public PageVo<Staff> queryByPageByDid(int page, int count, String did) {
		PageVo<Staff> vo = new PageVo<>();
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		List<Staff> list = dao.queryByPageByDid(index, count, did);
		if (list != null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(dao.queryCountByDid(did).intValue());
		} else {
			vo.setCode(1);
			vo.setMsg("暂无数据");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}

	@Override
	public Long queryCountByDid(String did) {

		return dao.queryCountByDid(did);
	}

	@Override
	public Long queryCount() {

		return dao.queryCount();
	}

	@Override
	public ResultVo queryMaxNo() {
		String no = dao.queryMaxNo();
		if (no != null) {
			return ResultVo.setOK(no);
		} else {
			return ResultVo.setERROR("null");
		}

	}

	@Override
	public boolean insertBatch(List<Staff> list) {
		// TODO Auto-generated method stub
		try {
			for (Staff s : list) {
				dao.insert(s);
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
