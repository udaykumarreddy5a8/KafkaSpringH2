package com.prombl.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prombl.consumer.model.AuditLog;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long>{
	
}
