package com.ibm.bug.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ibm.bug.repo.BugRepository;
import com.ibm.entity.Bug;

class BugServiceTest {

	@Test
	void testCreateBug() { // test case for creating bug
		BugService bugservice = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugservice.setBugRepository(dummyRepo);
		Bug bug = new Bug();
		String bugId = bugservice.createBug(bug);
		assertNotNull(bugId);
	}

	@Test
	void testGetBug() { // test case for getting bugs by id
		BugService bugservice = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugservice.setBugRepository(dummyRepo);
		bugservice.getBugRepository();
		Bug bug = new Bug();
		String bugName = bugservice.createBug(bug);
		List<Bug> bugList = bugservice.getBug(bugName);
		assertNotNull(bugList);
	}

	@Test
	void testGetBugs() { // test case for getting all bugs
		BugService bugservice = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugservice.setBugRepository(dummyRepo);
		bugservice.getBugRepository();
		List<Bug> bugList = bugservice.getBugs();
		assertNotNull(bugList);
	}

}
