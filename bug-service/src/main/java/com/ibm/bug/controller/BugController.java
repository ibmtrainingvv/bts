package com.ibm.bug.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bug.service.BugService;
import com.ibm.entity.Bug;
import com.ibm.entity.STATUS;

@RestController
public class BugController {
	@Autowired
	BugService bugService;

	Logger logger = Logger.getLogger(BugController.class.getName());

	/**
	 * method to create bug
	 * 
	 * @param bug
	 * @param bindingResult
	 * 
	 *                      returns bugId
	 */
	@PostMapping("/bug")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createBug(@RequestBody @Valid Bug bug, BindingResult bindingResult) {
		validateBug(bindingResult);
		logger.log(Level.INFO, bug.toString());
		return bugService.createBug(bug);
	}

	private void validateBug(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry.");
		}
	}

	/**
	 * method to search all bugs
	 * 
	 * returns list of bugs
	 */
	@GetMapping("/bug/")
	List<Bug> getBugs() {
		return bugService.getBugs();
	}

	/**
	 * method to search for bug by id
	 * 
	 * @param bugId
	 * 
	 *              returns zero or matching bug
	 */

	@GetMapping("/bug/{name}")
	List<Bug> getBug(@PathVariable("name") String bugName) {
		return bugService.getBug(bugName);
	}

	@GetMapping("/bug/status/{name}")
	List<Bug> getBug(@PathVariable("name") STATUS bugStatus) {
		return bugService.getBugByStatus(bugStatus);
	}

	@GetMapping("/bug/id/{id}")
	Optional<Bug> getBugById(@PathVariable("id") String bugId) {
		return bugService.getBugById(bugId);
	}

	@RequestMapping("/bug/search")
	List<Bug> findByStatusAndName(@RequestParam("status") STATUS bugStatus, @RequestParam("name") String name) {
		return bugService.findByStatusAndName(bugStatus, name);
	}
	
	@GetMapping("/bug/partialsearch/{name}")
	List<Bug> getBugByPartialName(@PathVariable("name") String bugName) {
		return bugService.getBugByPartialName(bugName);
	}

	/**
	 * method to update bug details
	 * 
	 * @param bug
	 * @param bindingResult
	 * @param bugId
	 */
	@PutMapping("/bug/{id}")
	void updateBug(@RequestBody @Valid Bug bug, BindingResult bindingResult, @PathVariable("id") String bugId) {
		validateBug(bindingResult);
		logger.log(Level.INFO, bugId);
		bug.setId(bugId);
		bugService.updateBugNew(bug);
	}
	@DeleteMapping("/bug/{id}")
	void deleteBug(@PathVariable("id") String bugId) {
		 bugService.deleteBug(bugId);
	}
}
