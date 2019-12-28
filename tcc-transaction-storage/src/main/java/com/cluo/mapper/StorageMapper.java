package com.cluo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageMapper {

	@Update({"update storage_tbl set count = count - #{count,jdbcType=INTEGER} where commodity_code=#{commodityCode,jdbcType=VARCHAR}"})
	public int updateStorage(Map<String,Object> map);
}
