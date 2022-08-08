package com.prombl.kafkamblapp.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.prombl.kafkamblapp.model.AuditLog;
import com.prombl.kafkamblapp.util.AppConstants;
import com.prombl.kafkamblapp.util.ServiceUtil;

@Service
public class MblConsumerService {
	
	private final Logger logger 
	= LoggerFactory.getLogger(MblConsumerService.class);
	@Autowired
	private PayloadLogService logService;
	@Autowired
	private ServiceUtil serviceUtil;

	@KafkaListener(topics = AppConstants.TOPIC_NAME_TEST, groupId = AppConstants.GROUP_ID)
	public void consume(String message) {
		logger.info(String.format("Message recieved -> %s", message));
	}
	
	@KafkaListener(topics = AppConstants.TOPIC_NAME_USER_LOG, groupId = AppConstants.GROUP_ID)
	public void save(String auditMsg) {
		//AuditLog log = new AuditLog();
		//msgMap = msgMap.replaceAll("=", ":");
		try {	
			AuditLog auditLog = (AuditLog) serviceUtil.convertToPOJO(auditMsg,AuditLog.class);
			logger.info(String.format("auditLog created -> %s", auditLog.toString()));
			logService.saveAuditLog(auditLog);
			logger.info(String.format("Customer created -> %s", auditMsg.toString()));
		}catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
