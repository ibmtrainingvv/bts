package com.ibm.bug.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
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
		bugService.getBugRepository();
		Bug bug = new Bug();
		String bugRecord = bugService.getBug(bugId)
	}

	@Test
	void testGetBugs() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBug() {
		fail("Not yet implemented");
	}

}
