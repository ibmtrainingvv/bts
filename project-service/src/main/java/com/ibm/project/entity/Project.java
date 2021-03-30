package com.ibm.project.entity;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Project {

	private String id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	private ArrayList<String> developerId;

	@NotNull
	private ArrayList<String> testerId;
	@NotNull
	private String managerId;

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

	public ArrayList<String> getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(ArrayList<String> developerId) {
		this.developerId = developerId;
	}

	public ArrayList<String> getTesterId() {
		return testerId;
	}

	public void setTesterId(ArrayList<String> testerId) {
		this.testerId = testerId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

}
