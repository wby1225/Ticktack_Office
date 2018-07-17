package com.feri.service;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Question;

public interface QuestionService {
	public boolean save(Question question);

	public PageVo<Question> queryQuestionByNo(String no);
}
