package com.prombl.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.prombl.consumer.model.AuditLog;
import com.prombl.consumer.util.AppConstants;
import com.prombl.consumer.util.ServiceUtil;

@Service
public class MblConsumerService {
	
	private final Logger logger 
	= LoggerFactory.getLogger(MblConsumerService.class);
	@Autowired
	private PayloadLogService logService;
	@Autowired
	private ServiceUtil serviceUtil;

	@KafkaListener(topics = AppConstants.TOPIC_NAME_USER_LOG, groupId = AppConstants.GROUP_ID)
	public void receiveCustomerData(String auditMsg) {
		long startTime = System.currentTimeMillis();
		logger.info("#MblConsumerService#receiveCustomerData#I# {}",startTime);
		try {	
			AuditLog auditLog = (AuditLog) serviceUtil.convertToPOJO(auditMsg,AuditLog.class);
			logService.saveAuditLog(auditLog);
			logger.info("#MblConsumerService#receiveCustomerData# {}", auditLog);
	    	logger.info("#MblConsumerService#receiveCustomerData#O# {}",(System.currentTimeMillis()-startTime));
		}catch (Exception e) {
			logger.error("#MblConsumerService#receiveCustomerData#E# {}",e.getMessage());
	    	logger.info("#MblConsumerService#receiveCustomerData#E# {}",(System.currentTimeMillis()-startTime));
			e.printStackTrace();
		}
		
	}

}
