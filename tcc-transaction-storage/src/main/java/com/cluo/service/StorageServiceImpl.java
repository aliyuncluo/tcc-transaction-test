package com.cluo.service;

import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.mapper.StorageMapper;

@Service
public class StorageServiceImpl implements StorageService {
    
	@Autowired
	private StorageMapper storageMapper;
	
	@Compensable(confirmMethod="confirmUpdateStorage",cancelMethod="cancelUpdateStorage")
	@Override
	public Boolean updateStorage(TransactionContext transactionContext,Map<String, Object> map) {
		String commodityCode = String.valueOf(map.get("commodityCode"));
		if(!"".equals(commodityCode) && commodityCode!=null) {
			return true;
		}
		return false;
	}
	
	public int confirmUpdateStorage(TransactionContext transactionContext,Map<String, Object> map) {
		return storageMapper.updateStorage(map);
	}

	public void cancelUpdateStorage(TransactionContext transactionContext,Map<String, Object> map) {
		System.out.println("更新库存信息失败");
	}
}
