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
	BugRepository bugRepository;

	public String createBug(Bug bug) {
		Bug savedbug = bugRepository.save(bug);
		return savedbug.getId();
	}

	public Optional<Bug> getBug(String orderId) {
		return bugRepository.findById(orderId);
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}

	public void updateBug(Bug bug) {
		bugRepository.save(bug);
	}

	public BugRepository getBugRepository() {
		return bugRepository;
	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

}
