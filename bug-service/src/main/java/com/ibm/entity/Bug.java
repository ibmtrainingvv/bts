package com.ibm.entity;

public class Bug {
	private String id;
	private String name;
	private PRIORITY priority;
	private String projectId;
	private String module;
	private TYPE type;
	private STATUS status;
	private String buildVersion;
	private SEVERITY severity;
	private String developerId;
	private String testerId;
	private String product;
	private String synopsis;
	private String description;

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
		if (synopsis.length() > 100) {
			throw new IndexOutOfBoundsException("Synopsis cannot be longer than 100 characters.");
		}
		this.synopsis = synopsis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description.length() > 250) {
			throw new IndexOutOfBoundsException("Cannot be longer than 250 characters");
		}
		this.description = description;
	}

}
