package com.cluo.service;

import java.util.Map;

import org.mengyun.tcctransaction.api.Compensable;

public interface BusinessService {

	@Compensable
	public Map<String,Object> tryShopping(Map<String,Object> map);
}
