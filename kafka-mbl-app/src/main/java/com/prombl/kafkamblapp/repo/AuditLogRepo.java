package com.prombl.kafkamblapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prombl.kafkamblapp.model.AuditLog;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long>{
	
}
