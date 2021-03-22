package com.awse.mapper;

import java.util.List;

import com.awse.domain.EmployeeVO;

public interface EmployeeMapper {
	
	public int insert(EmployeeVO employee);

	public List<EmployeeVO> getList();
	
	public EmployeeVO getById(int id);
	
	public List<EmployeeVO> getByCompanyId(int companyId);
	
}
