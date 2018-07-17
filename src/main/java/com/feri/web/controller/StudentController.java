package com.feri.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.feri.common.util.ExcelUtils;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Student;
import com.feri.domain.User;
import com.feri.service.StudentService;

//部门的数据接口 提供 新增、修改、删除、分页查询
@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// 新增
	@RequestMapping(value = "/studentadd.do", method = { RequestMethod.POST })
	public String add(Student student) {
		if (service.insert(student).getCode() == 1000) {
			return "studentlist";
		} else {
			return "studentadd";
		}
	}

	// 修改--基于Ajax
	@RequestMapping(value = "/studentupdate1.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo updateAjax(String name, int id) {
		return service.update(name, id);
	}

	// 修改--基于form表单
	@RequestMapping(value = "/studentupdate.do", method = { RequestMethod.POST })
	public String updateFrom(String name, int id) {
		if (service.update(name, id).getCode() == 1000) {
			return "studentlist";
		} else {
			return "studentupdate";
		}
	}

	// 删除--json格式数据 ---ajax
	@RequestMapping(value = "studentdelete.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo delete(int id) {
		return service.delete(id);
	}

	// 查询 --分页
	@RequestMapping(value = "studentpagebycno.do")
	@ResponseBody
	public PageVo<Student> queryPageByCno(int page, int limit, String cno) {
		System.out.println(cno);
		PageVo<Student> vo = service.queryByPageByCno(page, limit, cno);
		System.out.println(vo);
		return vo;
	}

	// 查询 --分页
	@RequestMapping(value = "studentpage.do")
	@ResponseBody
	public PageVo<Student> queryPage(int page, int limit) {
		PageVo<Student> vo = service.queryByPage(page, limit);
		System.out.println(vo);
		return vo;
	}

	@RequestMapping(value = "studentbatch.do", method = { RequestMethod.POST })
	public String batch(@RequestParam("mFile") CommonsMultipartFile mFile) throws IOException {
		List<Student> list = ExcelUtils.parseExcelS(mFile.getInputStream());
		System.out.println(list);
		if (service.insertBatch(list)) {
			return "studentlist";
		} else {
			return "studentbatch";
		}

	}

	@RequestMapping(value = "studentQueryByNo.do")
	@ResponseBody
	public Student queryByNo(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Student student = service.queryByNo(user.getNo());
		System.out.println(student);
		return student;

	}

	@RequestMapping(value = "studentQueryByNo1.do")
	@ResponseBody
	public Student queryByNo1(HttpServletRequest request, String no) {
		Student student = service.queryByNo(no);
		System.out.println(student);
		return student;

	}

	@RequestMapping(value = "querystudentbycno.do")
	@ResponseBody
	public PageVo<Student> queryByCno(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		PageVo<Student> vo = service.queryByCno(service.queryByNo(user.getNo()).getCno());

		return vo;

	}

}
