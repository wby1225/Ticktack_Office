package com.feri.service;

import java.util.List;

import com.feri.common.vo.PageVo;
import com.feri.common.vo.ResultVo;
import com.feri.domain.Staff;

public interface StaffService {
	ResultVo insert(Staff staff);

	// 修改
	ResultVo update(Staff staff);

	// 删除
	ResultVo delete(String no);

	// 查询 分页
	PageVo<Staff> queryByPage(int index, int count); 
	PageVo<Staff> queryByPageByDid(int index, int count,String did); 
	// 总数量
	Long queryCount();
	Long queryCountByDid(String did);
	ResultVo queryMaxNo();

	boolean insertBatch(List<Staff> list);
}
