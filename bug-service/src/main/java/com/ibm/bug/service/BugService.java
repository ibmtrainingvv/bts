package com.ibm.bug.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.bug.repo.BugRepository;
import com.ibm.entity.Bug;
import com.ibm.entity.STATUS;

@Service
public class BugService {

	@Autowired
	BugRepository bugRepository;
	@Autowired
	RestTemplate mailTemplate;

	public String createBug(Bug bug) {
		bug.setSubmitOn(new Date());
		Bug savedbug = bugRepository.save(bug);
		//mailTemplate.getForObject("http://localhost:8085/mail/{bugId}", Bug.class, bug.getId());

		return savedbug.getId();
	}

	public Optional<Bug> getBug(String bugId) {
		return bugRepository.findById(bugId);
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}

	public void updateBug(Bug bug) {
		STATUS status=bug.getStatus();
		Optional <Bug> oldBug=bugRepository.findById(bug.getId());
		oldBug.ifPresent(oldbug -> {
			STATUS oldstatus=oldbug.getStatus();
			if(oldstatus==STATUS.NEW) {
				if(!(status == STATUS.ASSIGNED || status == STATUS.NEW)) {
					throw new IllegalArgumentException("STATUS CAN ONLY BE ASSIGNED!");
				}
			}
			if(oldstatus == STATUS.ASSIGNED) {
				if(!(status == STATUS.OPEN || status == STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("STATUS CAN ONLY BE OPENED!");
				}
			}
			if(oldstatus == STATUS.OPEN) {
				if(!(status == STATUS.NOT_A_BUG || status == STATUS.REJECTED || status == STATUS.DUPLICATE || status == STATUS.DEFERRED || status == STATUS.COULD_NOT_REPRODUCE
						|| status == STATUS.NEED_MORE_INFO || status == STATUS.WONT_FIX || status == STATUS.OPEN)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if(oldstatus == STATUS.FIXED) {
				if(!(status == STATUS.PENDING_RETEST || status == STATUS.FIXED)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if(oldstatus == STATUS.PENDING_RETEST) {
				if(!(status == STATUS.RETEST || status == STATUS.PENDING_RETEST)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if(oldstatus == STATUS.RETEST) {
				if(!(status == STATUS.REOPEN || status == STATUS.VERIFIED || status == STATUS.RETEST)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if(oldstatus == STATUS.REOPEN) {
				if(!(status == STATUS.ASSIGNED || status == STATUS.REOPEN)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if(oldstatus == STATUS.VERIFIED) {
				if(!(status == STATUS.CLOSED || status == STATUS.VERIFIED)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if(oldstatus == STATUS.CLOSED) {
				if(!(status == STATUS.CLOSED)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
		});
		bugRepository.save(bug);

		//mailTemplate.getForObject("http://localhost:8085/mail/{bugId}", Bug.class, bug.getId());

	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public BugRepository getBugRepository() {
		return bugRepository;
	}
}
