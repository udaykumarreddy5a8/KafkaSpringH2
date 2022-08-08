package com.prombl.kafkamblapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prombl.kafkamblapp.model.ErrorLog;

@Repository
public interface ErrorLogRepo extends JpaRepository<ErrorLog, Long>{

}
