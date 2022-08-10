package com.prombl.kafkamblapp.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prombl.kafkamblapp.util.ServiceUtil;

@Component
public class ServiceUtil {
	private final Logger logger 
	= LoggerFactory.getLogger(ServiceUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();
	
	public String convertToJSON(Object object) {
		long startTime = System.currentTimeMillis();
		logger.info("#ServiceUtil#convertToJSON#I#"+startTime);
        try {
            if (object != null) {
            	logger.info("#ServiceUtil#convertToJSON#Object#",object);
            	logger.info("#ServiceUtil#convertToJSON#O#"+(System.currentTimeMillis()-startTime));
                return mapper.writeValueAsString(object);
            } else {
            	logger.error("#ServiceUtil#convertToJSON#E#object variable is null.");
            	logger.info("#ServiceUtil#convertToJSON#E#"+(System.currentTimeMillis()-startTime));
                throw new IllegalStateException("object variable is null.");
            }
        } catch (IOException ioe) {
        	logger.error("#ServiceUtil#convertToJSON#E#object variable parsing failed.");
        	logger.info("#ServiceUtil#convertToJSON#E#"+(System.currentTimeMillis()-startTime));
            throw new IllegalStateException("object variable parsing failed.", ioe);
        }
    }
	
}
