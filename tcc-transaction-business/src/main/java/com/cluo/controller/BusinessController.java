package com.cluo.controller;

import java.util.HashMap;
import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.feign.OrderService;
import com.cluo.feign.StorageService;
import com.cluo.service.BusinessService;

@RestController
public class BusinessController {
    Logger logger = LoggerFactory.getLogger(BusinessController.class);
    
	@Autowired
	private BusinessService businessService;
    
    @PostMapping("/test/shop")
    public Map<String,Object> shopping(@RequestBody Map<String,Object> map){
    	logger.info("传入的请求参数为："+map);
    	return businessService.tryShopping(map);
    }
}
