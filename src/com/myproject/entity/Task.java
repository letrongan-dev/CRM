package com.myproject.entity;

import java.util.Date;

public class Task {
	private int id;
	private String short_description;
	private String description;
	private Date start_date;
	private Date end_date;
	private int user_id;
	private int status;
	
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
	
}
