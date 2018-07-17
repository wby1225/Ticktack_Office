package com.feri.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.feri.common.util.ExcelUtils;
import com.feri.common.util.FileUtils;
import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Staff;
import com.feri.service.StaffService;

//部门的数据接口 提供 新增、修改、删除、分页查询
@Controller
public class StaffController {

	@Autowired
	StaffService service;

	@RequestMapping(value = "/staffadd.do", method = { RequestMethod.POST })
	public String fileupload(@RequestParam("f1") CommonsMultipartFile file, @ModelAttribute("staff") Staff staff,
			HttpServletRequest request) throws Exception {

		String fn = file.getOriginalFilename();
		System.out.println("文件上传：" + fn);
		// 获取上传文件夹 一个月一个文件夹
		File dir = FileUtils
				.createDir(new File(request.getServletContext().getRealPath("/")).getParent() + "/resources");
		// 获取需要保存的文件对象
		File destFile = new File(dir, FileUtils.createFileName(fn));
		// 保存文件
		file.transferTo(destFile);
		System.out.println(dir.getName() + "/" + destFile.getName());
		staff.setHeading(dir.getName() + "/" + destFile.getName());
		if (service.insert(staff).getCode() == 1000) {
			return "stafflist";
		} else {
			return "staffadd";
		}
	}

	// 修改--基于Ajax
	@RequestMapping(value = "/staffupdate1.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo updateAjax(Staff staff) {
		return service.update(staff);
	}

	// 修改--基于form表单
	@RequestMapping(value = "/staffupdate.do", method = { RequestMethod.POST })
	public String updateFrom(Staff staff) {
		if (service.update(staff).getCode() == 1000) {
			return "stafflist";
		} else {
			return "staffupdate";
		}
	}

	// 删除--json格式数据 ---ajax
	@RequestMapping(value = "staffdelete.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo delete(String no) {
		return service.delete(no);
	}

	// 查询 --分页
	@RequestMapping(value = "staffpage.do")
	@ResponseBody
	public PageVo<Staff> queryPage(int page, int limit) {
		PageVo<Staff> vo = service.queryByPage(page, limit);
		System.out.println(vo);
		return vo;

	}
	
	// 查询 --分页
	@RequestMapping(value = "staffpagebydid.do")
	@ResponseBody
	public PageVo<Staff> queryPageByDid(int page, int limit,String did) {
		PageVo<Staff> vo = service.queryByPageByDid(page, limit,did);
		System.out.println(vo);
		return vo;

	}

	@RequestMapping(value = "staffno.do")
	@ResponseBody
	public ResultVo queryMaxNo() {
		return service.queryMaxNo();
	}

	@RequestMapping(value = "staffbatch.do", method = { RequestMethod.POST })
	public String batch(@RequestParam("mFile") CommonsMultipartFile mFile) throws IOException {
		List<Staff> list=ExcelUtils.parseExcel(mFile.getInputStream());
		System.out.println(list);
		if(service.insertBatch(list)) {
			return "stafflist";
		} else { 
			return "staffbatch";
		}


	}

}
