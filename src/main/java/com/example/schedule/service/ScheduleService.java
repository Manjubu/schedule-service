package com.example.schedule.service;

import java.util.List;

import com.example.schedule.model.Schedule;

public interface ScheduleService {

	public Schedule saveSchedule(Schedule schedule);

	public List<Schedule> getAllSchedule();

	public Schedule getScheduleById(int scheduleId);

	public void deleteSchedule(int scheduleId);

	public Schedule updateSchedule(Schedule schedule);
}
