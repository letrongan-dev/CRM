package com.myproject.entity;

public class TaskAndUser extends Task {
	private String nameUser;

	public TaskAndUser() {
		
	}
	
	public TaskAndUser(String nameUser) {
		super();
		this.nameUser = nameUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	
}
