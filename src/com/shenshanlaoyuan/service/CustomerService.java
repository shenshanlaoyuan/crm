package com.shenshanlaoyuan.service;

import java.util.List;

import com.shenshanlaoyuan.pojo.BaseDict;
import com.shenshanlaoyuan.pojo.Customer;
import com.shenshanlaoyuan.pojo.QueryVo;

public interface CustomerService {

	public List<BaseDict> fingDictByCode(String code);
	
	public List<Customer> findCustomerByVo(QueryVo vo);
	public Integer findCustomerByVoCount(QueryVo vo);
}
