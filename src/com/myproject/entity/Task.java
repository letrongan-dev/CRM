package com.myproject.entity;

import java.sql.Date;

/**
 * @author dell 3559
 *
 */
public class Task {
	private int id;
	private String short_description;
	private String description;
	private Date start_date;
	private Date end_date;
	private int user_id;
	private int status;
	private int task_id;
	
	
	public Task(){
		
	}
	
	public Task(String short_description, String description, Date start_date, Date end_date, int user_id, int status) {
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user_id = user_id;
		this.status = status;
	}
	
	public Task(String short_description, String description, Date start_date, Date end_date, int userId) {
		super();
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user_id = userId;
	}
	
	public Task(String short_description, String description, Date start_date, Date end_date) {
		super();
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Task(String short_description, String description, Date start_date, Date end_date, int user_id, int status,
			int task_id) {
		super();
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user_id = user_id;
		this.status = status;
		this.task_id = task_id;
	}

	public Task(int id, String short_description, String description, Date start_date, Date end_date, int task_id) {
		super();
		this.id = id;
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.task_id = task_id;
	}

	public Task(int id, String short_description, String description, Date start_date, Date end_date) {
		super();
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	@Override
	public String toString() {
		return ("ID"+ id + " s-desc"+short_description+" desc"+description+" startdate"+start_date+" enđate"+end_date + " task" + task_id + "userId " + user_id);
	}
	
	
}
