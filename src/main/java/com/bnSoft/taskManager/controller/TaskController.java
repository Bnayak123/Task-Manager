package com.bnSoft.taskManager.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bnSoft.taskManager.entitys.TaskEntity;
import com.bnSoft.taskManager.service.TaskService;

@RequestMapping("/task")
@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public ResponseEntity<List<TaskEntity>> getTask() throws ParseException {
		var task = taskService.getAllTask();
		return ResponseEntity.ok(task);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id) {
		if (taskService.getTaskById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(taskService.getTaskById(id));

	}

	@PostMapping("/")
	public ResponseEntity<TaskEntity> createTask(@RequestBody Map<String, String> map ,TaskEntity task) {
		if(map.containsKey("title")) {
			System.out.println(map.get("title"));
		}
		return new ResponseEntity<TaskEntity>(taskService.addTask(task), HttpStatus.CREATED);

	}

	@PutMapping("/{id}/UpdateTask")
	public ResponseEntity<TaskEntity> updateTheTask(@PathVariable("id") Integer id, @RequestBody TaskEntity task) {
		TaskEntity updateTask = taskService.updateTask(task, id);
		if (updateTask == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updateTask);
	}

	@PatchMapping("/{id}/{b}")
	public ResponseEntity<TaskEntity> updateTheTask(@PathVariable Integer id, @PathVariable Boolean b) {
		if (taskService.updateTask(id, b) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(taskService.updateTask(id, b));
	}

}
