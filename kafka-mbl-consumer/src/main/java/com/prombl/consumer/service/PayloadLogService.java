package com.prombl.consumer.service;

import com.prombl.consumer.model.AuditLog;
import com.prombl.consumer.model.ErrorLog;

public interface PayloadLogService {

	 public void saveAuditLog(AuditLog auditLog);
	 public void saveErrorLog(ErrorLog errorLog);
	 
}
