package com.prombl.kafkamblapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prombl.kafkamblapp.model.AuditLog;
import com.prombl.kafkamblapp.model.ErrorLog;
import com.prombl.kafkamblapp.repo.AuditLogRepo;
import com.prombl.kafkamblapp.repo.ErrorLogRepo;

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
