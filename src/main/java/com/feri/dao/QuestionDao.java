package com.feri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.feri.domain.Question;

public interface QuestionDao {
	@Insert("insert into t_question (no,type,question,answer,flag,star) values (#{no},#{type},#{question},#{answer},1,#{star})")
	public int save(Question question);

	@Select("select * from t_question where flag=1 and no=#{no}")
	@ResultType(Question.class)
	public List<Question> queryQuestionByNo(String no);

	@Select("select count(1) from t_question where flag=1 and no=#{no}")
	@ResultType(Long.class)
	public Long queryCountByNo(String no);
}
