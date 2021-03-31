package com.ibm.bug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bug.entity.bug;
import com.ibm.bug.repo.bugRepository;

@Service
public class bugService {
	@Autowired
	bugRepository bugRepository;

	@Transactional
	public String createbug(bug bug) {
		bug savedbug = bugRepository.save(bug);
		if(bug != null) {
			throw new RuntimeException();
		}
		return savedbug.getId();
	}

	public Optional<bug> getbug(String orderId) {
		return bugRepository.findById(orderId);
	}

	public List<bug> getbugs() {
		return bugRepository.findAll();
	}

	public void updatebug(bug bug) {
		bugRepository.save(bug);
	}

}
