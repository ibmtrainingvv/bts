package com.ibm.bug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bug.entity.bug;

	@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;


	public String createBug(Bug bug) {
		bug savedbug = bugRepository.save(bug);
				return savedbug.getId();
	}

	public Optional<Bug> getbug(String orderId) {
		return bugRepository.findById(orderId);
	}

	public List<Bug> getbugs() {
		return bugRepository.findAll();
	}

	public void updatebug(Bug bug) {
		bugRepository.save(bug);
	}

}
