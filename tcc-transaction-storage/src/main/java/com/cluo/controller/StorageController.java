package com.cluo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.service.StorageService;

@RestController
public class StorageController {

	@Autowired
	private StorageService storageService;
	
	@PostMapping("/test/storage")
	public Boolean updateStorage(@RequestBody Map<String,Object> map) {
		System.out.println("===进入到库存管理===");
		return storageService.updateStorage(null,map);
	}
}
