package com.feri.web.converter;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

//重写ObjectMapper
//@Component //等价于<bean>
public class DateMapper extends ObjectMapper{

	private static final long serialVersionUID = 1L;

	public DateMapper() {
		setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	}
}
