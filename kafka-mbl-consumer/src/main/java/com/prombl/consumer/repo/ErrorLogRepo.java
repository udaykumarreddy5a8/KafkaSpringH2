package com.prombl.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prombl.consumer.model.ErrorLog;

@Repository
public interface ErrorLogRepo extends JpaRepository<ErrorLog, Long>{

}
