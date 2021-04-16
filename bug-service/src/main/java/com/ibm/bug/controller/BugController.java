package com.ibm.bug.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bug.service.BugService;
import com.ibm.entity.Bug;

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
	
	@GetMapping("/bug/{id}")
	Optional<Bug> getBug(@PathVariable("id") String bugId) {
		System.out.println("hit");
		return bugService.getBug(bugId);
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
		bugService.updateBug(bug);
	}
}
