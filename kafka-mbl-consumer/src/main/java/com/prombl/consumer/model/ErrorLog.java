package com.prombl.consumer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERROR_LOG")
public class ErrorLog {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
    private Long id;
	
	@Column(name="ERROR_TYPE")
	private String errorType;
	
	@Column(name="ERROR_DESCRIPTION")
	private String errorDescription;
	
	@Column(name="PAYLOAD",columnDefinition = "JSON")
	private String payload;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	
}
