package com.prombl.kafkamblapp.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiceUtil {

	
	private final Logger logger 
	= LoggerFactory.getLogger(ServiceUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();
	
	public String convertToJSON(Object object) {
        try {
            if (object != null) {
            	logger.info("object is not null#",object);
                return mapper.writeValueAsString(object);
            } else {
            	logger.error("object variable is null.");
                throw new IllegalStateException("object variable is null.");
            }
        } catch (IOException ioe) {
        	logger.error("object variable parsing failed.");
            throw new IllegalStateException("object variable parsing failed.", ioe);
        }
    }
	
	public Object convertToPOJO(String payload, Class<?> clazz) {
        try {
            if (payload != null) {
                return mapper.readValue(payload, clazz);
            } else {
            	logger.error("payload variable is null.");
                throw new IllegalStateException("payload variable is null.");
            }
        } catch (IOException ioe) {
        	logger.error("payload variable parsing failed.");
            throw new IllegalStateException("payload variable parsing failed.", ioe);
        }
    }
}
