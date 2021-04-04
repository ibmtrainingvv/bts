package com.ibm.mail.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mail.service.MailService;

@RestController
public class MailController {
	@Autowired
	MailService mailService;

	@GetMapping("/mail/{id}")
	void sendMail(@PathVariable("id") String bugId) {
		try {
			System.out.println(bugId);

			mailService.sendEmailWithAttachment(bugId);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
