package com.shenshanlaoyuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shenshanlaoyuan.pojo.BaseDict;
import com.shenshanlaoyuan.pojo.QueryVo;
import com.shenshanlaoyuan.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Value("${customer.dict.source}")
	private String source;
	
	@Value("${customer.dict.industry}")
	private String industry;
	
	@Value("${customer.dict.level}")
	private String level;
	
	@RequestMapping("/list")
	public String list(QueryVo vo,Model model) throws Exception{
		//客户来源
		List<BaseDict> sourceList = customerService.fingDictByCode(source);
		//所属行业
		List<BaseDict> industryList = customerService.fingDictByCode(industry);
		//客户级别
		List<BaseDict> levelList = customerService.fingDictByCode(level);
		
		//高级查询下拉列表数据
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		if (vo.getCustName()!=null) {
			//解决get请求乱码
			vo.setCustName(new String(vo.getCustName().getBytes("iso8859-1"),"utf-8"));
		}
		
		
		//高级查询数据回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
}
