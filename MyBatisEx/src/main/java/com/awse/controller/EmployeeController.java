package com.awse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awse.domain.EmployeeVO;
import com.awse.mapper.EmployeeMapper;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/employee")
@Log4j
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@PostMapping("")
	public EmployeeVO register(@RequestBody EmployeeVO employee) {
		
		log.info("add Employee : "+ employee);
		employeeMapper.insert(employee);
		log.info("add Employee : "+ employee);
		
		return employee;
	}
	
}
