package com.prombl.consumer.util;

import java.time.format.DateTimeFormatter;

public class AppConstants {
	
	private AppConstants() {
		
	}

	public static final String TOPIC_NAME_TEST = "test";
	public static final String TOPIC_NAME_USER_LOG = "customers-log";
	public static final String GROUP_ID = "group_id";
	public static final DateTimeFormatter DATE_FORMAT_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
}
