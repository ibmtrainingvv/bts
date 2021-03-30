package com.ibm.project.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Project {
	@NotNull
	private int projectId ;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	private int developerId;
	@NotNull
	private int testerId;
	@NotNull
	private int managerId;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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
