package com.ibm.mail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Bug;
import com.ibm.mail.repo.BugRepository;

@Service
public class MailService {

	@Autowired
	BugRepository bugRepository;

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
