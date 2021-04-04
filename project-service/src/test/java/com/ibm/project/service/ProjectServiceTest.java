package com.ibm.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ibm.project.entity.Project;
import com.ibm.project.repo.ProjectRepository;

class ProjectServiceTest {

	@Test
	void testCreateProject() { // test case for creation of project
		ProjectService projectService = new ProjectService();
		ProjectRepository dummyRepo = new DummyProjectRepository();
		projectService.setProjectRepository(dummyRepo);
		Project project = new Project();
		String projectId = projectService.createProject(project);
		assertNotNull(projectId);
	}

	@Test
	void testGetProject() { // test case for getting project by id
		ProjectService projectService = new ProjectService();
		ProjectRepository dummyRepo = new DummyProjectRepository();
		projectService.setProjectRepository(dummyRepo);
		projectService.getProjectRepository();
		Project project = new Project();
		String projectId = projectService.createProject(project);
		Optional<Project> projectRecord = projectService.getProject(projectId);
		assertEquals(true, projectRecord.isPresent());
	}

	@Test
	void testGetProjects() { // test case for getting list of projects
		ProjectService projectService = new ProjectService();
		ProjectRepository dummyRepo = new DummyProjectRepository();
		projectService.setProjectRepository(dummyRepo);
		projectService.getProjectRepository();
		List<Project> projectList = projectService.getProjects();
		assertNotNull(projectList);
	}

}
