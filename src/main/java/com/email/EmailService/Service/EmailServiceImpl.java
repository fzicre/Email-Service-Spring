// Zicre Francisco 2022
package com.email.EmailService.Service;


// Importing required classes
import com.email.EmailService.Entity.EmailDetails;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") private String sender;

	
	public String sendSimpleMail(EmailDetails details)
	{

		
		try {

			
			SimpleMailMessage mailMessage
				= new SimpleMailMessage();

			
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());

			
			javaMailSender.send(mailMessage);
			return "Email sent...";
		}

		
		catch (Exception e) {
			return "Error: Mail not sent.";
		}
	}


	public String
	sendMailWithAttachment(EmailDetails details)
	{
		
		MimeMessage mimeMessage
			= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			
			mimeMessageHelper
				= new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(
				details.getSubject());

			
			FileSystemResource file
				= new FileSystemResource(
					new File(details.getAttachment()));

			mimeMessageHelper.addAttachment(
				file.getFilename(), file);

			
			javaMailSender.send(mimeMessage);
			return "Email sent...";
		}

		
		catch (MessagingException e) {

			
			return "Error: Mail not sent.";
		}
	}
}
