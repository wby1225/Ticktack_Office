package com.feri.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feri.common.util.AddressUtils;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Loginlog;
import com.feri.domain.User;
import com.feri.service.LoginlogService;
import com.feri.service.UserService;

//操作用户表
@Controller
public class UserController {
	@Autowired
	private UserService service;

	@Autowired
	LoginlogService loginlogService;

	// InternalResourceViewResolver
	// 登录
	@RequestMapping(value = "/login.do", method = { RequestMethod.POST })
	public String login(String no, String pass, HttpSession session, HttpServletResponse resp,
			HttpServletRequest request) {
		User user = service.queryByNo(no, pass);
		System.out.println(user);
		if (user != null) {
			session.setAttribute("user", user);
			Cookie ck = new Cookie("user", user.getNo());
			ck.setMaxAge(-1);
			resp.addCookie(ck);
			addLoginlog(request, user.getNo());
			return "index";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/loginajax.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo loginAjax(String no, String pass, HttpSession session, HttpServletResponse resp,
			HttpServletRequest request) {
		User user = service.queryByNo(no, pass);
		ResultVo vo = new ResultVo();
		System.out.println(user);
		if (user != null) {
			vo = ResultVo.setOK("登陆成功跳转");
			session.setAttribute("user", user);
			Cookie ck = new Cookie("user", user.getNo());
			ck.setMaxAge(-1);
			resp.addCookie(ck);
			addLoginlog(request, user.getNo());
			return vo;
		} else {
			vo=ResultVo.setERROR("帐号密码有误");
			return vo;
		}
	}

	// 注销
	@RequestMapping("/loginout.do")
	public void loginout(HttpSession session,HttpServletResponse response) {
		session.removeAttribute("user");
		try {
			response.sendRedirect("login.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean addLoginlog(HttpServletRequest request, String no) {
		try {
			String[] list = AddressUtils.getAddresses(AddressUtils.getIp(request), "UTF-8");
			Loginlog loginlog = new Loginlog();
			loginlog.setLocation(list[3] + "-" + list[4]);
			loginlog.setIp(AddressUtils.getIp(request) + "/" + request.getRemoteAddr());
			loginlog.setNo(no);
			loginlogService.loginlogAdd(loginlog);
			return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}

}
