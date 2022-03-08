package com.example.schedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schedule.entity.ScheduleEntity;
import com.example.schedule.exception.ScheduleNotFoundException;
import com.example.schedule.model.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.util.EntityModelUtil;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		ScheduleEntity scheduleEntity = scheduleRepository.save(EntityModelUtil.scheduleModelToEntity(schedule));
		return EntityModelUtil.scheduleEntityToModel(scheduleEntity);
	}

	@Override
	public List<Schedule> getAllSchedule() {
		List<ScheduleEntity> scheduleEntityList = scheduleRepository.findAll();
		return EntityModelUtil.scheduleEntityToModelList(scheduleEntityList);
	}

	@Override
	public Schedule getScheduleById(int scheduleId) {
		Optional<ScheduleEntity> optionalSchedule = scheduleRepository.findById(scheduleId);
		if (optionalSchedule.isEmpty()) {
			throw new ScheduleNotFoundException("Sorry! Schedule is not existing with id :" + scheduleId);
		}
		return EntityModelUtil.scheduleEntityToModel(optionalSchedule.get());
	}

	@Override
	public void deleteSchedule(int scheduleId) {
		Optional<ScheduleEntity> optional = scheduleRepository.findById(scheduleId);
		if (optional.isEmpty()) {
			throw new ScheduleNotFoundException("Sorry! Schedule is not existing with id :" + scheduleId);
		}
		scheduleRepository.deleteById(scheduleId);

	}

	@Override
	public Schedule updateSchedule(Schedule schedule) {
		Optional<ScheduleEntity> optional = scheduleRepository.findById(schedule.getScheduleId());
		if (optional.isEmpty()) {
			throw new ScheduleNotFoundException("Sorry! Schedule is not existing with id :" + schedule.getScheduleId());
		}
		ScheduleEntity scheduleEntity = scheduleRepository.save(EntityModelUtil.scheduleModelToEntity(schedule));
		return EntityModelUtil.scheduleEntityToModel(scheduleEntity);
	}

}
