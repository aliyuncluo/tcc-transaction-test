package com.cluo.service;

import java.util.HashMap;
import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.Propagation;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cluo.feign.OrderService;
import com.cluo.feign.StorageService;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	private OrderService orderService;
    @Autowired
    private StorageService storageService;
    
    @Compensable(propagation=Propagation.REQUIRED,confirmMethod="confirmShopping",cancelMethod="cancelShopping",transactionContextEditor=MethodTransactionContextEditor.class)
    public Map<String,Object> tryShopping(Map<String,Object> map){
    	Map<String,Object> result = new HashMap<>(); 
    	String commodityCode = String.valueOf(map.get("commodityCode"));
    	 if(!StringUtils.isEmpty(commodityCode)) {
    		 result.put("code", 200);
    		 result.put("message", "校验项通过");
    		 return result;
    	 }
    	 result.put("code", 500);
		 result.put("message", "校验项不通过");
    	return result;
    }
  
    public Map<String,Object> confirmShopping(Map<String,Object> map){
    	Map<String,Object> result = new HashMap<>();
    	//更新库存
    	Map<String,Object> storageMap = new HashMap<>();
    	storageMap.put("commodityCode", map.get("commodityCode"));
    	storageMap.put("count", map.get("count"));
    	Boolean storage = storageService.updateStorage(storageMap);
    	//创建订单
    	Map<String,Object> orderMap = new HashMap<>();
    	orderMap.put("userId", map.get("userId"));
    	orderMap.put("commodityCode", map.get("commodityCode"));
    	orderMap.put("count", map.get("count"));
    	orderMap.put("money", map.get("money"));
    	Boolean order = orderService.tryCreateOrder(orderMap);
    	if(storage==true && order==true) {
    		result.put("code", 200);
    		result.put("message", "操作成功");
    	}else {
    		result.put("code", 500);
    		result.put("message", "服务操作失败");
    	}
    	return result;
    }
    
    public Map<String,Object> cancelShopping(Map<String,Object> map){
    	Map<String,Object> result = new HashMap<>();
    	result.put("code", 500);
		result.put("message", "服务操作失败");
		return result;
    }
}
