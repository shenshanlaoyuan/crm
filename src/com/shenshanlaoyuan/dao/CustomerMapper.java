package com.shenshanlaoyuan.dao;

import java.util.List;

import com.shenshanlaoyuan.pojo.Customer;
import com.shenshanlaoyuan.pojo.QueryVo;

public interface CustomerMapper {

	public List<Customer> findCustomerByVo(QueryVo vo);
	public Integer findCustomerByVoCount(QueryVo vo);
}
