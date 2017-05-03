package com.shenshanlaoyuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shenshanlaoyuan.pojo.BaseDict;
import com.shenshanlaoyuan.pojo.Customer;
import com.shenshanlaoyuan.pojo.QueryVo;
import com.shenshanlaoyuan.service.CustomerService;

import cn.itcast.utils.Page;

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
	
	/**
	 * 查询展示customer列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(QueryVo vo,Model model) throws Exception{
		//客户来源
		List<BaseDict> sourceList = customerService.fingDictByCode(source);
		//所属行业
		List<BaseDict> industryList = customerService.fingDictByCode(industry);
		//客户级别
		List<BaseDict> levelList = customerService.fingDictByCode(level);
		
		if (vo.getCustName()!=null) {
			//解决get请求乱码
			vo.setCustName(new String(vo.getCustName().getBytes("iso8859-1"),"utf-8"));
		}
		
		if (vo.getPage() == null) {
			vo.setPage(1);
		}
		
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		
		//查询数据列表和数据总数
		List<Customer> customerlist = customerService.findCustomerByVo(vo);
		Integer count = customerService.findCustomerByVoCount(vo);
		
		//分页
		Page<Customer> page = new Page<Customer>();
		page.setTotal(count);	   //数据总数
		page.setSize(vo.getSize());//每页显示条数
		page.setPage(vo.getPage());//当前页数
		page.setRows(customerlist);//数据列表
		
		model.addAttribute("page", page);
		
		
		//高级查询下拉列表数据
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		
		
		
		//高级查询数据回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		
		
		return "customer";
	}
	
	/**
	 * 修改页面数据回显
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detail")
	@ResponseBody
	public Customer detail(Long id) throws Exception{
		Customer customer = customerService.findCustomerById(id);
		return customer;
	}
	
	/**
	 * 修改customer
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	public String update(Customer customer) throws Exception{
		
		customerService.updateCustomerById(customer);
		
		return "customer";
	}
	/**
	 * 删除customer
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String update(Long id) throws Exception{
		
		customerService.delCustomerById(id);
		
		return "customer";
	}
}
