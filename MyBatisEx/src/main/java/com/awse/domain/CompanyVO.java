package com.awse.domain;

import java.util.List;

import lombok.Data;

@Data
public class CompanyVO {

	private int id;
	private String name;
	private String address;
	private List<EmployeeVO> employeeList;
	
}
