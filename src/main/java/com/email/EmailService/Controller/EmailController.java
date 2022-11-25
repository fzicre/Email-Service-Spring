// Zicre Francisco 2022
package com.email.EmailService.Controller;


// Importing required classes
import com.email.EmailService.Entity.EmailDetails;
import com.email.EmailService.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController
// Class
public class EmailController {

	@Autowired private EmailService emailService;

	// Sending Email
	@PostMapping("/sendMail")
	public String
	sendMail(@RequestBody EmailDetails details)
	{
		String status
			= emailService.sendSimpleMail(details);

		return status;
	}

	// Sending Email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(
		@RequestBody EmailDetails details)
	{
		String status
			= emailService.sendMailWithAttachment(details);

		return status;
	}
}
