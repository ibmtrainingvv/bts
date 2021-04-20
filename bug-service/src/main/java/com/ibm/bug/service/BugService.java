package com.ibm.bug.service;

import java.util.Date;
import java.util.HashMap;
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

	@Autowired
	StatusIllegalArgumentException statusIllegalArgumentException;

	public String createBug(Bug bug) {
		bug.setSubmitOn(new Date());
		if (!(bug.getStatus() == STATUS.NEW || (bug.getStatus() == STATUS.ASSIGNED && bug.getDeveloperId() != null))) {
			throw new StatusIllegalArgumentException("STATUS value can be only NEW or ASSIGNED with Developer ID");
		}
		Bug savedbug = bugRepository.save(bug);
		// mailTemplate.getForObject("http://localhost:8085/mail/{bugId}", Bug.class,
		// bug.getId());

		return savedbug.getId();
	}

	public List<Bug> getBug(String bugName) {
		return bugRepository.findByName(bugName);
	}

	public List<Bug> getBugByStatus(STATUS bugStatus) {
		return bugRepository.findByStatus(bugStatus);
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}

	public void updateBugNew(Bug bug) {
		STATUS status = bug.getStatus();
		Optional<Bug> oldBug = bugRepository.findById(bug.getId());
		oldBug.ifPresent(oldbug -> {
			STATUS oldstatus = oldbug.getStatus();
			HashMap<STATUS, STATUS[]> hmap = new HashMap<STATUS, STATUS[]>();
			hmap.put(STATUS.NEW, new STATUS[] { STATUS.ASSIGNED });
			hmap.put(STATUS.ASSIGNED, new STATUS[] { STATUS.OPEN });
			hmap.put(STATUS.OPEN, new STATUS[] { STATUS.NOT_A_BUG, STATUS.REJECTED, STATUS.DUPLICATE, STATUS.DEFERRED,
					STATUS.FIXED, STATUS.COULD_NOT_REPRODUCE });
			hmap.put(STATUS.DEFERRED, new STATUS[] { STATUS.ASSIGNED });
			hmap.put(STATUS.FIXED, new STATUS[] { STATUS.PENDING_RETEST });
			hmap.put(STATUS.PENDING_RETEST, new STATUS[] { STATUS.RETEST });
			hmap.put(STATUS.RETEST, new STATUS[] { STATUS.VERIFIED, STATUS.REOPEN });
			hmap.put(STATUS.NOT_A_BUG, new STATUS[] { STATUS.ASSIGNED, STATUS.VERIFIED });
			hmap.put(STATUS.REJECTED, new STATUS[] { STATUS.ASSIGNED, STATUS.VERIFIED });
			hmap.put(STATUS.DUPLICATE, new STATUS[] { STATUS.ASSIGNED, STATUS.VERIFIED });
			hmap.put(STATUS.VERIFIED, new STATUS[] { STATUS.CLOSED });
			hmap.put(STATUS.REOPEN, new STATUS[] { STATUS.ASSIGNED });
			hmap.put(STATUS.CLOSED, new STATUS[] { STATUS.CLOSED });
			hmap.put(STATUS.COULD_NOT_REPRODUCE, new STATUS[] { STATUS.NEED_MORE_INFO });
			hmap.put(STATUS.NEED_MORE_INFO, new STATUS[] { STATUS.ASSIGNED });
			int i = 0;
			String errorMsg = "-";
			for (i = 0; i < hmap.get(oldstatus).length; i++) {
				errorMsg += "  ";
				if (status == hmap.get(oldstatus)[i]) {
					break;
				}
				errorMsg += hmap.get(oldstatus)[i];
			}
			if (hmap.get(oldstatus).length == i && !(oldstatus == status)) {
				throw new StatusIllegalArgumentException("STATUS CAN ONLY BE " + errorMsg);
			}
			bugRepository.save(bug);

		});

	}

	public void updateBug(Bug bug) {
		STATUS status = bug.getStatus();
		Optional<Bug> oldBug = bugRepository.findById(bug.getId());
		oldBug.ifPresent(oldbug -> {
			STATUS oldstatus = oldbug.getStatus();
			if (oldstatus == STATUS.NEW) {
				if (!(status == STATUS.ASSIGNED || status == STATUS.NEW)) {
					// sendError();
					throw new StatusIllegalArgumentException("STATUS CAN ONLY BE ASSIGNED!");
				}
			}
			if (oldstatus == STATUS.ASSIGNED) {
				if (!(status == STATUS.OPEN || status == STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("STATUS CAN ONLY BE OPENED!");
				}
			}
			if (oldstatus == STATUS.OPEN) {
				if (!(status == STATUS.NOT_A_BUG || status == STATUS.REJECTED || status == STATUS.DUPLICATE
						|| status == STATUS.DEFERRED || status == STATUS.COULD_NOT_REPRODUCE
						|| status == STATUS.NEED_MORE_INFO || status == STATUS.WONT_FIX || status == STATUS.OPEN)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if (oldstatus == STATUS.FIXED) {
				if (!(status == STATUS.PENDING_RETEST || status == STATUS.FIXED)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if (oldstatus == STATUS.PENDING_RETEST) {
				if (!(status == STATUS.RETEST || status == STATUS.PENDING_RETEST)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if (oldstatus == STATUS.RETEST) {
				if (!(status == STATUS.REOPEN || status == STATUS.VERIFIED || status == STATUS.RETEST)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if (oldstatus == STATUS.REOPEN) {
				if (!(status == STATUS.ASSIGNED || status == STATUS.REOPEN)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if (oldstatus == STATUS.VERIFIED) {
				if (!(status == STATUS.CLOSED || status == STATUS.VERIFIED)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
			if (oldstatus == STATUS.CLOSED) {
				if (!(status == STATUS.CLOSED)) {
					throw new IllegalArgumentException("STATUS NOT SUITABLE!");
				}
			}
		});
		bugRepository.save(bug);

		// mailTemplate.getForObject("http://localhost:8085/mail/{bugId}", Bug.class,
		// bug.getId());

	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public BugRepository getBugRepository() {
		return bugRepository;
	}

	public Optional<Bug> getBugById(String bugId) {
		return bugRepository.findById(bugId);
	}
}
