package com.example.schedule.exception;

public class ScheduleNotFoundException extends RuntimeException {

	public ScheduleNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
