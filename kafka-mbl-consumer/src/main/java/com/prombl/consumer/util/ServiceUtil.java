package com.prombl.consumer.util;

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
	
	public Object convertToPOJO(String payload, Class<?> clazz) {
		long startTime = System.currentTimeMillis();
		logger.info("#ServiceUtil#convertToPOJO#I#"+startTime);
        try {
            if (payload != null) {
            	logger.info("#ServiceUtil#convertToPOJO#payload#",payload);
            	logger.info("#ServiceUtil#convertToPOJO#O#"+(System.currentTimeMillis()-startTime));
                return mapper.readValue(payload, clazz);
            } else {
            	logger.error("#ServiceUtil#convertToJSON#E#payload variable is null.");
            	logger.info("#ServiceUtil#convertToJSON#E#"+(System.currentTimeMillis()-startTime));
                throw new IllegalStateException("payload variable is null.");
            }
        } catch (IOException ioe) {
        	logger.error("payload variable parsing failed.");
        	logger.info("#ServiceUtil#convertToJSON#E#"+(System.currentTimeMillis()-startTime));
            throw new IllegalStateException("payload variable parsing failed.", ioe);
        }
    }
}
