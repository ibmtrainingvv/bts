package com.ibm.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.project.entity.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {

}
