package com.feri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.dao.LoginlogDao;
import com.feri.domain.Loginlog;
import com.feri.service.LoginlogService;

@Service
public class LoginlogServiceImpl implements LoginlogService {
	@Autowired
	LoginlogDao dao;

	@Override
	public boolean loginlogAdd(Loginlog loginlog) {
		return dao.loginlogAdd(loginlog) > 0;
	}

	@Override
	public PageVo<Loginlog> queryAll(int page, int count) {
		PageVo<Loginlog> vo = new PageVo<>();
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		System.out.println(index+"________"+count);
		List<Loginlog> list = dao.queryAll(index, count);
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

}
