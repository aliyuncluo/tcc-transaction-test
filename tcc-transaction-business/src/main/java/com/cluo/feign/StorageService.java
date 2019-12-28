package com.cluo.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="tcc-transaction-storage")
public interface StorageService {

	@PostMapping("/test/storage")
	public Boolean updateStorage(@RequestBody Map<String,Object> map); 
}
