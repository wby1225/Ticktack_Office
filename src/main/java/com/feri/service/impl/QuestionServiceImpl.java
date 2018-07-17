package com.feri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.dao.QuestionDao;
import com.feri.domain.Question;
import com.feri.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao dao;

	@Override
	public  boolean save(Question question) {
		return dao.save(question)>0;
		
	}

	@Override
	public PageVo<Question> queryQuestionByNo(String no) {
		PageVo<Question> vo = new PageVo<Question>();
		
		List<Question> list = dao.queryQuestionByNo(no);
		if (list != null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(dao.queryCountByNo(no).intValue());
		} else {
			vo.setCode(1);
			vo.setMsg("暂无数据");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}

}
