package com.ibm.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ibm.bug.service.StatusIllegalArgumentException;

public class Bug {
	private String id;
	@NotNull
	private String name;
	@NotNull
	private PRIORITY priority;
	@NotNull
	private String projectId;
	@NotNull
	private String module;
	@NotNull
	private TYPE type;
	@NotNull
	private STATUS status;
	private Date submitOn;
	private String buildVersion;
	@NotNull
	private SEVERITY severity;
	private String developerId;
	private String testerId;
	private String product;
	@NotNull
	@Size(min = 5, max = 50, message = "Synopsis should not be more than 50 characters.")
	@NotBlank
	private String synopsis;
	@Size(min = 5, max = 200, message = "Description should not be more than 200 characters.")
	@NotBlank
	private String description;
	private Date eta;

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

	public PRIORITY getPriority() {
		return priority;
	}

	public void setPriority(PRIORITY priority) {
		this.priority = priority;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public SEVERITY getSeverity() {
		return severity;
	}

	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public String getTesterId() {
		return testerId;
	}

	public void setTesterId(String testerId) {
		this.testerId = testerId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.trim();
	}

	public Date getSubmitOn() {
		return submitOn;
	}

	public void setSubmitOn(Date submitOn) {
		this.submitOn = submitOn;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		if (eta.compareTo(new Date()) < 0) {
			throw new StatusIllegalArgumentException("ETA cannot be past day");
		}
		this.eta = eta;
	}

}
