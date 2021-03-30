package com.ibm.project.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Project {
	@NotNull
	private float tax;
	@NotNull
	@NotBlank
	private String item;
	@NotNull
	private int id;
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
