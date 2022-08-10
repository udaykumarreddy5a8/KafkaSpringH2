package com.prombl.kafkamblapp.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prombl.kafkamblapp.model.Customer;
import com.prombl.kafkamblapp.service.MblProducerService;
import com.prombl.kafkamblapp.util.ServiceUtil;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/customerservice")
@SecurityRequirement(name = "mbluseapi")
public class ProducerController {

	private final Logger logger 
	= LoggerFactory.getLogger(ProducerController.class);
	
	private final MblProducerService producerService;

	@Autowired
	private ServiceUtil serviceUtil;
	
	@Autowired
	public ProducerController(MblProducerService producerService) {
		this.producerService = producerService;
	}
	
	@PostMapping(
		value = "/create",
		consumes = {MediaType.APPLICATION_JSON_VALUE},
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<Object> sendMessageToKafkaTopic(@Valid @RequestBody Customer customerDetails,@RequestHeader MultiValueMap<String, String> headers) {

		long startTime = System.currentTimeMillis();
		logger.info("#ProducerController#sendMessageToKafkaTopic#I#{}",startTime);
		Map<String,Object> response = new LinkedHashMap<>();
		try {
			
			String customerNumber = customerDetails.getCustomerNumber();
			String birthdate = customerDetails.getBirthdate();
			String email = customerDetails.getEmail();
			
			/*Masking - Start*/
			customerDetails.setCustomerNumber(customerNumber.substring(0, customerNumber.length() - 4) + "****");
			customerDetails.setBirthdate(birthdate.replaceFirst(birthdate.substring(0,4),"****"));
			customerDetails.setEmail(email.replaceFirst(email.substring(0,4),"****"));
			/*Masking - End*/
			
			this.producerService.saveCreateCustomerLog(customerDetails.getCustomerNumber(),serviceUtil.convertToJSON(customerDetails));
			response.put("status","success");
			response.put("message","Message Sent Successfully");
		}catch (Exception e) {
			response.put("status","failed");
			response.put("message","Message Send Failed");
			response.put("errorType",e.getMessage());
        	logger.info("#ProducerController#sendMessageToKafkaTopic#E# {}",(System.currentTimeMillis()-startTime));
		}
    	logger.info("#ProducerController#sendMessageToKafkaTopic#O# {}",(System.currentTimeMillis()-startTime));
		return ResponseEntity.ok(response);
	}
	
	
}
