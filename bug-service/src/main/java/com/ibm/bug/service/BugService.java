package com.ibm.bug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bug.repo.BugRepository;
import com.ibm.entity.Bug;

@Service
public class BugService {

	@Autowired
	BugRepository bugRepository; // Dependency Injection

	public String createBug(Bug bug) {
		Bug savedbug = bugRepository.save(bug);
		return savedbug.getId();
	}

	public Optional<Bug> getBug(String bugId) {
		return bugRepository.findById(bugId);
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}

	public void updateBug(Bug bug) {
		bugRepository.save(bug);
	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public BugRepository getBugRepository() {
		return bugRepository;
	}
}
