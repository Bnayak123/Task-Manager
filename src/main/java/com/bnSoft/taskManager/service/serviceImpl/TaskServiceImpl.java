package com.bnSoft.taskManager.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bnSoft.taskManager.entitys.TaskEntity;
import com.bnSoft.taskManager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

	List<TaskEntity> taskList = new ArrayList<>();
	int id = 1;

	@Override
	public List<TaskEntity> getAllTask() {
		return taskList;
	}

	@Override
	public TaskEntity addTask(TaskEntity task) {
		if (task != null) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			
			log.info(stackTrace[0]+ " "+"Givan task is Empty " + task);
		}
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setId(id);
		if (task.getTitle() != null) {
			taskEntity.setTitle(task.getTitle());
		}
		if (task.getDedline() != null) {
			taskEntity.setDedline(task.getDedline());
		}
		if (task.getDescription() != null) {
			taskEntity.setDescription(task.getDescription());
		}
		taskEntity.setCompleted(false);
		taskList.add(taskEntity);
		id++;
		return taskEntity;
	}

	@Override
	public TaskEntity getTaskById(Integer id) {
		if (id == null) {
			log.info("Givan Id is Empty");
			return null;
		} else {
			return taskList.stream().filter(task -> task.getId() == id).findAny().orElse(null);
		}
//		for (TaskEntity task : taskList)
//			if (task.getId() == id) {
//				return task;
//			}
//		return null;
	}

	@Override
	public TaskEntity updateTask(TaskEntity task, Integer id) {
		if (id == null) {
			log.info(Object.class +"Givan Id is Empty");
		} else {
			if (getTaskById(id) != null) {
				if (task != null) {
					TaskEntity taskById = getTaskById(id);
					if (task.getTitle() != null) {
						taskById.setTitle(task.getTitle());
					}
					if (task.getDedline() != null) {
						taskById.setDedline(task.getDedline());
					}
					if (task.getDescription() != null) {
						taskById.setDescription(task.getDescription());
					}
					return taskById;
				}
				log.info("Givan task is Empty" + task);
			}
			log.info("Task not present in the given Id :" + id);
		}

		return null;
	}

	@Override
	public TaskEntity updateTask(Integer id, Boolean b) {
		if (id == null) {
			log.info("Givan Id is Empty");
		} else {
			if (getTaskById(id) != null) {
				TaskEntity taskById = getTaskById(id);
				taskById.setCompleted(b);
				return taskById;
			}
			log.info("Task not present in the given Id :" + id);
		}
		return null;
	}

}
