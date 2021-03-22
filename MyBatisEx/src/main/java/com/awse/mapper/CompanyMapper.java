package com.awse.mapper;

import java.util.List;

import com.awse.domain.CompanyVO;

public interface CompanyMapper {

	public int insert(CompanyVO company);
	
	public List<CompanyVO> getList();
	
	public CompanyVO getById(int id);
	
}
