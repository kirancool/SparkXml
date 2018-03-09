package com.sparkxml.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkxml.dao.StoreDao;

@Service("storeService")
public class StoreServiceImpl implements StoreService{
	@Autowired
	StoreDao storeDao;

	public List<Map<String, Object>> getStoreData() {
		List<Map<String, Object>> ss=storeDao.getStoreData();
		return ss;
	}
}
