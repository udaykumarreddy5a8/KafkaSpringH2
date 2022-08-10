package com.prombl.kafkamblapp.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prombl.kafkamblapp.util.AppConstants;

@Service
public class MblProducerService {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MblProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void saveCreateCustomerLog(String customerNumber, String message) 
	{
		long startTime = System.currentTimeMillis();
		logger.info("#MblProducerService#saveCreateCustomerLog#I#"+startTime);
		

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			Map<String,Object> elements=new HashMap<String,Object>();
			elements.put("customerNumber", customerNumber);
			elements.put("payload", message);
			
			String auditMsg = objectMapper.writeValueAsString(elements);
			
			logger.info(String.format("#MblProducerService#saveCreateCustomerLog#Customer Request Sent# %s", auditMsg));
			
			this.kafkaTemplate.send(AppConstants.TOPIC_NAME_USER_LOG, auditMsg);
			
        	logger.info("#MblProducerService#saveCreateCustomerLog#O#"+(System.currentTimeMillis()-startTime));
		}catch (Exception e) {
        	logger.error("Customer Request Failed.");
        	logger.info("#MblProducerService#saveCreateCustomerLog#E#"+(System.currentTimeMillis()-startTime));
        	e.printStackTrace();
            throw new IllegalStateException("Customer Request Failed", e);
		}
	}
	
}
