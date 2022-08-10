package com.prombl.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prombl.consumer.model.AuditLog;
import com.prombl.consumer.model.ErrorLog;
import com.prombl.consumer.repo.AuditLogRepo;
import com.prombl.consumer.repo.ErrorLogRepo;

@Service
public class PayloadLogServiceImpl implements PayloadLogService {

	@Autowired
	private AuditLogRepo auditLogRepo;
	
	@Autowired
	private ErrorLogRepo errorLogRepo;
	
	@Override
	public void saveAuditLog(AuditLog auditLog) {
		auditLogRepo.save(auditLog);		
	}

	@Override
	public void saveErrorLog(ErrorLog errorLog) {
		errorLogRepo.save(errorLog);
	}

}
