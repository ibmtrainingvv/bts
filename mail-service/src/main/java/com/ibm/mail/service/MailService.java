package com.ibm.mail.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.entity.Bug;
import com.ibm.entity.Employee;
import com.ibm.entity.Project;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	RestTemplate getTaxesTemplate;

	public void sendEmailWithAttachment(String bugId) throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessage msg1 = javaMailSender.createMimeMessage();

		Bug bug = getTaxesTemplate.getForObject("http://localhost:8083/bug/{bugId}", Bug.class, bugId);
		Project project = getTaxesTemplate.getForObject("http://localhost:8082/project/{projectId}", Project.class,
				bug.getProjectId());
		Employee employee = getTaxesTemplate.getForObject("http://localhost:8080/employee/{projectId}", Employee.class,
				project.getManagerId());
		String mailTo = employee.getEmailId();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(mailTo);

		if (bug.getStatus().name().equals("NEW")) {
			helper.setSubject("creation of new Bug report for project " + project.getName());

			// default = text/plain
			// true = text/html
			helper.setText(
					"<!DOCTYPE html> <html> <head> <style> table { font-family: arial, sans-serif; border-collapse:"
							+ " collapse; width: 100%; "
							+ "} td, th { border: 1px solid #dddddd; text-align: left; padding: 8px; } tr:nth-child(even) {"
							+ " background-color: #dddddd; } </style> </head> <body> <h2>new bug for project "
							+ project.getName() + " " + "</h2> <table> <tr> <th>" + "project id </th> <th>"
							+ project.getId() + "</th>  </tr> <tr> <td>bugId</td> <td>" + bug.getId() + " "
							+ "</td> </tr> <tr> <td>Tester id </td> <td>" + bug.getTesterId()
							+ "</td> </tr> <tr> <td>Developer Id</td> <td>" + "<i> YET TO ASSIGNED" + "</td> "
							+ " </tr> <tr> <td>Description</td> <td>" + bug.getDescription()
							+ "</td>  </tr> </table> <br><br> <b> Hosted with <p style=\"color:red;\">&hearts;<p> on BUGHAWK </body> </html>",
					true);

			javaMailSender.send(msg);
		}

		else if (bug.getStatus().name().equals("ASSIGNED")) {
			System.out.println(bug.getDeveloperId());
			employee = getTaxesTemplate.getForObject("http://localhost:8080/employee/{projectId}", Employee.class,
					project.getManagerId());
			String mailTo1 = employee.getEmailId();
			MimeMessageHelper helper1 = new MimeMessageHelper(msg1, true);

			helper1.setTo(mailTo1);

			helper.setSubject("Updation of Bug status for project " + project.getName() + " to ASSIGNED");
			helper1.setSubject("Updation of Bug status for project " + project.getName() + " to ASSIGNED");

			String msgToSent = ("<!DOCTYPE html> <html> <head> <style> table { font-family: arial, sans-serif; border-collapse:"
					+ " collapse; width: 100%; "
					+ "} td, th { border: 1px solid #dddddd; text-align: left; padding: 8px; } tr:nth-child(even) {"
					+ " background-color: #dddddd; } </style> </head> <body> <h2>Status updation of bug for project "
					+ project.getName() + " <br> Bug ASSIGNED TO Developer " + employee.getName() + "with id "
					+ employee.getId() + "</h2> <table> <tr> <th>" + "project id </th> <th>" + project.getId()
					+ "</th>  </tr> <tr> <td>bugId</td> <td>" + bug.getId() + " "
					+ "</td> </tr> <tr> <td>Tester id </td> <td>" + bug.getTesterId()
					+ "</td> </tr> <tr> <td>Developer Id</td> <td>" + bug.getDeveloperId() + "</td> "
					+ " </tr> <tr> <td>Description</td> <td>" + bug.getDescription()
					+ "</td>  </tr> </table> <br><br> <b> Hosted with <p style=\"color:red;\">&hearts;<p> on BUGHAWK </body> </html>");

			helper.setText(msgToSent, true);
			helper1.setText(msgToSent, true);
			javaMailSender.send(msg);
			javaMailSender.send(msg1);

		}

	}
}
