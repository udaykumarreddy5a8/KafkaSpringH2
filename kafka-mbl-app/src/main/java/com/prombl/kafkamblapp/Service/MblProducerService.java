package com.prombl.kafkamblapp.Service;

import java.util.HashMap;
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
	
//	@Autowired
//	private AuditLog auditLog;

	public void sendMessage(String message) 
	{
		logger.info(String.format("Message sent -> %s", message));
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME_TEST, message);
	}
	
	public void saveCreateCustomerLog(String customerNumber, String message) 
	{
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, String> jsonMap = mapper.readValue(message, Map.class);
//		StringBuilder msgStr = new StringBuilder("{");
//		msgStr.append(String.format("\"%s\"","customerNumber")).append(":").append(String.format("\"%s\"",customerNumber)).append(",");
//		msgStr.append(String.format("\"%s\"","payload")).append(":").append(message).append("}");
//		
		try {
			Map<String,Object> elements=new HashMap<String,Object>();
			elements.put("customerNumber", customerNumber);
			elements.put("payload", message);
			
			ObjectMapper objectMapper = new ObjectMapper();
			String auditMsg = objectMapper.writeValueAsString(elements);
			
			logger.info(String.format("Customer Request Sent -> %s", auditMsg));
			this.kafkaTemplate.send(AppConstants.TOPIC_NAME_USER_LOG, auditMsg);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
