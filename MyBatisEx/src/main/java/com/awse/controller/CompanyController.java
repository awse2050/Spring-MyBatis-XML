package com.awse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awse.domain.CompanyVO;
import com.awse.mapper.CompanyMapper;
import com.awse.service.CompanyService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/company")
@Log4j
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private CompanyService service;
	
	@PostMapping("")
	public CompanyVO register(@RequestBody CompanyVO company) {
		log.info(company);
		companyMapper.insert(company);
		log.info(company);
		
		return company;
	}
	
	@GetMapping("")
	public List<CompanyVO> getList() {
//		service.getList().forEach(list -> log.info(list));
		companyMapper.getList().forEach(list -> log.info(list));
		
		return companyMapper.getList();
	}
	
	@GetMapping("/{id}")
	public CompanyVO get(@PathVariable("id") int id) {
		
		log.info("Company Id : " + id);
		
		return companyMapper.getById(id);
		
	}
	
}
