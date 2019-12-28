package com.cluo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

	@Insert({"insert into order_tbl (user_id,commodity_code,count,money) "
			+ "values (#{userId,jdbcType=VARCHAR},#{commodityCode,jdbcType=VARCHAR},#{count,jdbcType=INTEGER},#{money,jdbcType=DECIMAL})"})
	int createOrder(Map<String,Object> map);
}
