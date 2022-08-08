package com.prombl.kafkamblapp.Service;

import com.prombl.kafkamblapp.model.AuditLog;
import com.prombl.kafkamblapp.model.ErrorLog;

public interface PayloadLogService {

	 public void saveAuditLog(AuditLog auditLog);
	 public void saveErrorLog(ErrorLog errorLog);
	 
}
