package com.bnSoft.taskManager.service;

import java.util.List;

import com.bnSoft.taskManager.entitys.TaskEntity;

public interface TaskService {

	List<TaskEntity> getAllTask();

	TaskEntity addTask(TaskEntity task);

	TaskEntity getTaskById(Integer id);

	TaskEntity updateTask(TaskEntity task, Integer id);
	
	TaskEntity updateTask(Integer id,Boolean b);

}
