package com.cluo.service;

import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.cluo.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService{
    
	@Autowired
	private OrderMapper orderMapper;
	
	@Compensable(confirmMethod="confirmCreateOrder",cancelMethod="cancelCreateOrder")
	@Override
	public Boolean tryCreateOrder(TransactionContext transactionContext,Map<String, Object> orderMap) {
		String userId = String.valueOf(orderMap.get("userId"));
		if(!StringUtils.isEmpty(userId)) {
			return true;
		}
		return false;
	}


	public int confirmCreateOrder(TransactionContext transactionContext,Map<String, Object> orderMap) {
		int orderNum = orderMapper.createOrder(orderMap);
		return orderNum;
	}

	
	public int cancelCreateOrder(TransactionContext transactionContext,Map<String, Object> orderMap) {
		System.out.println("创建订单失败");
		return 0;
	}

}
