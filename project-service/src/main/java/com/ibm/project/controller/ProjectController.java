package com.ibm.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.project.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@PostMapping("/project")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createProject(@RequestBody @Valid Project project, BindingResult bindingResult) {
		validateProject(bindingResult);
		System.out.println(project);
		return projectService.createProject(project);
	}

	private void validateProject(BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry.");
		}
	}

	@GetMapping("/project")
	List<Project> getProjects() {
		return projectService.getProjects();
	}

	@GetMapping("/project/{id}")
	Optional<Project> getProject(@PathVariable("id") String projectId) {
		return projectService.getProject(projectId);
	}

	@PutMapping("/project/{id}")
	void updateProject(@RequestBody @Valid Project project, BindingResult bindingResult,
			@PathVariable("id") String projectId) {
		validateProject(bindingResult);
		System.out.println(projectId);
		project.setId(projectId);
		projectService.updateProject(project);
	}
}
