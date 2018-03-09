package com.sparkxml.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparkxml.service.StoreService;

@RestController
@RequestMapping(value="/stores")
public class StoreController {
	
@Autowired
StoreService storeService;

@RequestMapping(value="/getStoreData", method=RequestMethod.GET)
public @ResponseBody List<Map<String, Object>> getStoreData() {
	return storeService.getStoreData();
}

}
