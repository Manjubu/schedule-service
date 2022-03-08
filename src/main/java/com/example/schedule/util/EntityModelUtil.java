package com.example.schedule.util;

import java.util.ArrayList;
import java.util.List;

import com.example.schedule.entity.ScheduleEntity;
import com.example.schedule.model.Schedule;

public class EntityModelUtil {
	public static ScheduleEntity scheduleModelToEntity(Schedule schedule) {
		ScheduleEntity scheduleEntity = new ScheduleEntity();

		scheduleEntity.setScheduleId(schedule.getScheduleId());
		scheduleEntity.setScheduleDate(schedule.getScheduleDate());
		scheduleEntity.setScheduleVenue(schedule.getScheduleVenue());
		scheduleEntity.setStartTime(schedule.getStartTime());
		scheduleEntity.setTeam1Name(schedule.getTeam1Name());
		scheduleEntity.setTeam2Name(schedule.getTeam2Name());

		return scheduleEntity;
	}

	public static Schedule scheduleEntityToModel(ScheduleEntity scheduleEntity) {
		Schedule schedule = new Schedule();

		schedule.setScheduleId(scheduleEntity.getScheduleId());
		schedule.setScheduleDate(scheduleEntity.getScheduleDate());
		schedule.setScheduleVenue(scheduleEntity.getScheduleVenue());
		schedule.setStartTime(scheduleEntity.getStartTime());
		schedule.setTeam1Name(scheduleEntity.getTeam1Name());
		schedule.setTeam2Name(scheduleEntity.getTeam2Name());

		return schedule;
	}

	public static List<Schedule> scheduleEntityToModelList(List<ScheduleEntity> entityList) {
		List<Schedule> scheduleList = new ArrayList<>();

		entityList.forEach(entity -> {

			Schedule schedule = new Schedule();

			schedule.setScheduleId(entity.getScheduleId());
			schedule.setScheduleDate(entity.getScheduleDate());
			schedule.setScheduleVenue(entity.getScheduleVenue());
			schedule.setStartTime(entity.getStartTime());
			schedule.setTeam1Name(entity.getTeam1Name());
			schedule.setTeam2Name(entity.getTeam2Name());

			scheduleList.add(schedule);
		});
		return scheduleList;
	}
}
