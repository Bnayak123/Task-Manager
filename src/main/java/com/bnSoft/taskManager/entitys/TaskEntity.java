package com.bnSoft.taskManager.entitys;

import java.util.Date;

import lombok.Data;

@Data
public class TaskEntity {
	private int id;
	private String title;
	private Date dedline;
	private String description;
	private boolean completed;
	
	

	

}
