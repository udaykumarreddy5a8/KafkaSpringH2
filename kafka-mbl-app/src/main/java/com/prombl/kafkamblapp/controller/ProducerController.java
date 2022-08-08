package com.prombl.kafkamblapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prombl.kafkamblapp.Service.MblProducerService;
import com.prombl.kafkamblapp.model.Customer;
import com.prombl.kafkamblapp.util.ServiceUtil;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/customerservice")
@SecurityRequirement(name = "mbluseapi")
@Validated
public class ProducerController {
	
	private final MblProducerService producerService;

	@Autowired
	private ServiceUtil serviceUtil;
	
	@Autowired
	public ProducerController(MblProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producerService.sendMessage(message);
	}
	
	@PostMapping(
		value = "/create",
		consumes = {MediaType.APPLICATION_JSON_VALUE},
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<String> sendMessageToKafkaTopic(@Valid @RequestBody Customer cusomerDetails) {
		
		this.producerService.saveCreateCustomerLog(cusomerDetails.getCustomerNumber(),serviceUtil.convertToJSON(cusomerDetails));
		return ResponseEntity.ok("Success");
	}
}
