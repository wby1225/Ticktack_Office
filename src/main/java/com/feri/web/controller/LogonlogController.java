package com.feri.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feri.common.vo.PageVo;
import com.feri.domain.Loginlog;
import com.feri.service.LoginlogService;

@Controller
public class LogonlogController {
	@Autowired
	LoginlogService service;
	
	@RequestMapping(value = "loginlogpage.do")
	@ResponseBody
	public PageVo<Loginlog> queryPage(int page, int limit) {
		PageVo<Loginlog> vo = service.queryAll(page, limit);
		System.out.println(vo);
		return vo;

	}
}
