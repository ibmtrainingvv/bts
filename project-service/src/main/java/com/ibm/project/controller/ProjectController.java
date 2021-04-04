package com.ibm.project.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.project.entity.Project;
import com.ibm.project.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService; // Dependency Injection
	
	Logger logger = Logger.getLogger(ProjectController.class.getName());

	/**
	 * method to create project
	 * 
	 * @param project
	 * @param bindingResult 
	 * 
	 * returns projectId
	 */
	@PostMapping("/project")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createProject(@RequestBody @Valid Project project, BindingResult bindingResult) {
		validateProject(bindingResult);
		logger.log(Level.INFO, project.toString());
		return projectService.createProject(project);
	}

	private void validateProject(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry.");
		}
	}

	/**
	 * method to search all projects 
	 * 
	 * returns list of projects
	 */
	@GetMapping("/project")
	List<Project> getProjects() {
		return projectService.getProjects();
	}

	/**
	 * method to search for project by id
	 * 
	 * @param projectId 
	 * 
	 * returns zero or matching project
	 */
	@GetMapping("/project/{id}")
	Optional<Project> getProject(@PathVariable("id") String projectId) {
		return projectService.getProject(projectId);
	}

	/**
	 * method to update project details
	 * 
	 * @param project
	 * @param bindingResult
	 * @param projectId
	 */
	@PutMapping("/project/{id}")
	void updateProject(@RequestBody @Valid Project project, BindingResult bindingResult,
			@PathVariable("id") String projectId) {
		validateProject(bindingResult);
		logger.log(Level.INFO,projectId);
		project.setId(projectId);
		projectService.updateProject(project);
	}
}
