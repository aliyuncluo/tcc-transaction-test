package com.cluo.controller;

import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.Compensable.DefaultTransactionContextEditor;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.service.OrderService;

@RestController
public class OrderController {
    @Autowired
	private OrderService orderService;
    
    @PostMapping("/test/order")
    public Boolean tryCreateOrder(@RequestBody Map<String,Object> orderMap) {
    	System.out.println("===进入订单管理===");
    	try {
			Thread.sleep(90000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return orderService.tryCreateOrder(null,orderMap);
    }
    
}
