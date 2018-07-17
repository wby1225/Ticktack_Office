package com.feri.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Grade;
import com.feri.service.GradeService;

@Controller
public class GradeController {
	@Autowired
	GradeService service;

	@RequestMapping(value = "gradeadd.do", method = { RequestMethod.POST })

	public String add(Grade grade) {
		if (service.add(grade).getCode() == 1000) {
			return "gradelist";
		} else {
			return "gradeadd";
		}

	}

	@RequestMapping(value = "gradeupdate.do", method = { RequestMethod.POST })
	public String update(Grade grade) {
		if(service.update(grade).getCode()==1000) {
			return "gradelist";
		}else {
			return "gradelupdate";
		}
	}

	@RequestMapping(value = "gradedelete.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo delete(int id) {
		return service.delete(id);
	}

	@RequestMapping(value = "gradequeryall.do", method = { RequestMethod.GET })
	@ResponseBody
	public PageVo<Grade> queryAll(int page, int limit) {
		PageVo<Grade> pageVo = service.queryAll(page, limit);
		System.out.println(pageVo);
		return pageVo;
	}
	
	@RequestMapping(value="gradeall.do")
	@ResponseBody
	public List<Grade> queryGradeAll(){
		return service.queryGradeAll();
	}
}
