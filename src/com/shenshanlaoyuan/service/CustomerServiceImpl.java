package com.shenshanlaoyuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenshanlaoyuan.dao.CustomerMapper;
import com.shenshanlaoyuan.dao.DictMapper;
import com.shenshanlaoyuan.pojo.BaseDict;
import com.shenshanlaoyuan.pojo.Customer;
import com.shenshanlaoyuan.pojo.QueryVo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private DictMapper dictMapper;
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<BaseDict> fingDictByCode(String code) {
		List<BaseDict> list = dictMapper.fingDictByCode(code);
		return list;
	}

	@Override
	public List<Customer> findCustomerByVo(QueryVo vo) {
		List<Customer> list = customerMapper.findCustomerByVo(vo);
		return list;
	}

	@Override
	public Integer findCustomerByVoCount(QueryVo vo) {
		Integer count = customerMapper.findCustomerByVoCount(vo);
		return count;
	}

	@Override
	public Customer findCustomerById(Long id) {
		Customer customer = customerMapper.findCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

	@Override
	public void delCustomerById(Long id) {

		customerMapper.delCustomerById(id);
	}

}
