package com.feri.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.feri.common.util.FileUtils;
import com.feri.common.vo.ResultVo;
import com.feri.service.StaffService;

//部门的数据接口 提供 新增、修改、删除、分页查询
@Controller
public class PhotouploadController {

	@Autowired
	StaffService service;

	@RequestMapping(value = "/photoupload.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo fileupload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request)
			throws Exception {

		String fn = file.getOriginalFilename();
		System.out.println("文件上传：" + fn);
		// 获取上传文件夹 一个月一个文件夹
		File dir = FileUtils
				.createDir(new File(request.getServletContext().getRealPath("/")).getParent() + "/resources");
		// 获取需要保存的文件对象
		File destFile = new File(dir, FileUtils.createFileName(fn));
		// 保存文件
		file.transferTo(destFile);
		System.out.println("文件路径" + destFile.getAbsolutePath());
		System.out.println(dir.getName() + "/" + destFile.getName());
		ResultVo vo = new ResultVo();
		String photo = dir.getName() + "/" + destFile.getName();
		if (photo.length() > 8) {
			vo = ResultVo.setOK(photo);
		} else {
			vo = ResultVo.setERROR("上传失败");
		}
		return vo;

	}

}
