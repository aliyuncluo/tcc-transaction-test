package com.cluo.service;

import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;

public interface OrderService {

	@Compensable
	public Boolean tryCreateOrder(TransactionContext transactionContext,Map<String, Object> orderMap);
	
}
