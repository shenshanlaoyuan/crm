package com.shenshanlaoyuan.service;

import java.util.List;

import com.shenshanlaoyuan.pojo.BaseDict;

public interface CustomerService {

	public List<BaseDict> fingDictByCode(String code);
}
