package com.cluo.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="tcc-transaction-order")
public interface OrderService {

	@PostMapping("/test/order")
    public Boolean tryCreateOrder(@RequestBody Map<String,Object> orderMap);
}
