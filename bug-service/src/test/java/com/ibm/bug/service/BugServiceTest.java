package com.ibm.bug.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ibm.bug.repo.BugRepository;
import com.ibm.entity.Bug;

class BugServiceTest {

	@Test
	void testCreateBug() {
		BugService bugService = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugService.setBugRepository(dummyRepo);
		Bug bug = new Bug();
		String bugId = bugService.createBug(bug);
		assertNotNull(bugId);
	}

	@Test
	void testGetBug() {
		BugService bugService = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugService.setBugRepository(dummyRepo);
		bugService.getBugRepository();
		Bug bug = new Bug();
		String bugId = bugService.createBug(bug);
		Optional<Bug> bugRecord = bugService.getBug(bugId);
	}

	@Test
	void testGetBugs() {
		BugService bugService = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugService.setBugRepository(dummyRepo);
		bugService.getBugRepository();
		List<Bug> bugList = bugService.getBugs();
	}

	@Test
	void testUpdateBug() {
		BugService bugService = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugService.setBugRepository(dummyRepo);
		Bug bug = new Bug();
		String bugId = bugService.createBug(bug);
		assertNotNull(bugId);
	}

}
