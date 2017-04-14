package com.shenshanlaoyuan.dao;

import java.util.List;

import com.shenshanlaoyuan.pojo.BaseDict;

public interface DictMapper {

	public List<BaseDict> fingDictByCode(String code);
	
}
