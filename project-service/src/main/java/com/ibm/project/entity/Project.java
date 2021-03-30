package com.ibm.project.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Project {
	
	private String id ;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	private int developerId;
	@NotNull
	private int testerId;
	@NotNull
	private int managerId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public int getTesterId() {
		return testerId;
	}
	public void setTesterId(int testerId) {
		this.testerId = testerId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	
}
