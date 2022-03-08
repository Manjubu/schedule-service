package com.example.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedule.model.Schedule;
import com.example.schedule.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@PostMapping("/save")
	public ResponseEntity<Schedule> addInning(@RequestBody Schedule schedule) {
		Schedule newSchedule = scheduleService.saveSchedule(schedule);
		return new ResponseEntity<Schedule>(newSchedule, HttpStatus.CREATED);
	}

	@GetMapping("/get/all")
	public List<Schedule> getAllScheduleDetails() {
		return scheduleService.getAllSchedule();
	}

	@GetMapping("/get/{schedule_id}")
	public ResponseEntity<?> getScheduleDetailsById(@PathVariable("schedule_id") int scheduleId) {
		Schedule scheduleDetails = scheduleService.getScheduleById(scheduleId);
		return new ResponseEntity<>(scheduleDetails, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{schedule_id}")
	public void deleteInning(@PathVariable("schedule_id") int scheduleId) {
		scheduleService.deleteSchedule(scheduleId);
	}

	@PutMapping("/{update}")
	public Schedule updateSchedule(@RequestBody Schedule schedule) {
		return scheduleService.updateSchedule(schedule);
	}
}
