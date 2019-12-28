package com.cluo.service;

import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;

public interface StorageService {

	@Compensable
	public Boolean updateStorage(TransactionContext transactionContext,Map<String,Object> map);
}
