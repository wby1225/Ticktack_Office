package com.feri.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Question;
import com.feri.domain.User;
import com.feri.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService service;

	@RequestMapping(value = "savequestion.do")
	public String save(Question question, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		question.setNo(user.getNo());
		System.out.println("aaa");
		if(service.save(question)){
			return "resourcelibrary";
		}
		return  "questionadd";
	}

	@RequestMapping(value = "queryquestionbyno.do")
	@ResponseBody
	public PageVo<Question> queryQuestionByNo(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return service.queryQuestionByNo(user.getNo());

	}

}
