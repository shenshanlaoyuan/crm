package com.shenshanlaoyuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shenshanlaoyuan.pojo.BaseDict;
import com.shenshanlaoyuan.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;
	
	@Value("${customer.dict.source}")
	private String source;
	
	@Value("${customer.dict.industry}")
	private String industry;
	
	@Value("${customer.dict.level}")
	private String level;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		//客户来源
		List<BaseDict> sourceList = customerService.fingDictByCode(source);
		//所属行业
		List<BaseDict> industryList = customerService.fingDictByCode(industry);
		//客户级别
		List<BaseDict> levelList = customerService.fingDictByCode(level);
		
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		return "customer";
	}
}
