package com.feri.service;

import com.feri.common.vo.PageVo;
import com.feri.domain.Loginlog;

public interface LoginlogService {
	public boolean loginlogAdd(Loginlog loginlog);

	public PageVo<Loginlog> queryAll(int page,int limit);
}
