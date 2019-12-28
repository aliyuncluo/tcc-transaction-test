package com.cluo.config;

import javax.sql.DataSource;

import org.mengyun.tcctransaction.TransactionRepository;
import org.mengyun.tcctransaction.serializer.KryoTransactionSerializer;
import org.mengyun.tcctransaction.serializer.ObjectSerializer;
import org.mengyun.tcctransaction.spring.recover.DefaultRecoverConfig;
import org.mengyun.tcctransaction.spring.repository.SpringJdbcTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ImportResource(locations = "classpath:tcc-transaction.xml")
public class TccConfig {
	
	@Bean
    public TransactionRepository transactionRepository(ObjectSerializer<?> serializer) {
        SpringJdbcTransactionRepository repository = new SpringJdbcTransactionRepository();
        repository.setDataSource(druidDataSource());
        repository.setDomain("TRADE");
        repository.setTbSuffix("_TRADE");
        repository.setSerializer(serializer);
        return repository;
    }

	/**
     * 设置恢复策略
     * @return
     */
    @Bean
    public DefaultRecoverConfig defaultRecoverConfig(){
        DefaultRecoverConfig defaultRecoverConfig=new DefaultRecoverConfig();
        defaultRecoverConfig.setCronExpression("0 */1 * * * ?");
        defaultRecoverConfig.setMaxRetryCount(120);
        defaultRecoverConfig.setMaxRetryCount(30);
        return defaultRecoverConfig;
    }
    
    @ConfigurationProperties(value = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        DruidDataSource datasource = new DruidDataSource();
        return datasource;
    }

    @Bean
    public ObjectSerializer<?> objectSerializer() {
        return new KryoTransactionSerializer();
    }
	
}
