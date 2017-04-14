package com.shenshanlaoyuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenshanlaoyuan.dao.DictMapper;
import com.shenshanlaoyuan.pojo.BaseDict;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private DictMapper dictMapper;

	@Override
	public List<BaseDict> fingDictByCode(String code) {
		List<BaseDict> list = dictMapper.fingDictByCode(code);
		return list;
	}

}
