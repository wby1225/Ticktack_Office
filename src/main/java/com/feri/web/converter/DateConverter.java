package com.feri.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//自定义日期转换器  字符串转换为Date 格式yyyy-MM-dd
public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String value) {
		System.out.println("自定义转换器");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
