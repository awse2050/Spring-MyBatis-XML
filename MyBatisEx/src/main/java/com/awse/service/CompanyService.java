package com.awse.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awse.domain.CompanyVO;
import com.awse.mapper.CompanyMapper;
import com.awse.mapper.EmployeeMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<CompanyVO> getList() {
		
		List<CompanyVO> companyList = companyMapper.getList();
		
		if(Objects.nonNull(companyList)) {
			companyList.forEach(company -> {
				
				company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
				
			});
		}
		
		return companyList;
		
	}
	
}
