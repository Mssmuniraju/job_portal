package com.set_job_portal.Service;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.PdfContentByte;
import com.set_job_portal.DTO.EmailRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService 
{
//	@Autowired
//	private JavaMailSender mailSender;
//	
//	
//	public void simpleSendEmail(EmailRequestDTO dto) {
//		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(dto.getTo());
//		message.setSubject(dto.getSubject());
//		message.setText(dto.getBody());
//		
//		mailSender.send(message);
//		
//	}
	
	
	public void sendEmail(com.set_job_portal.DTO.EmailRequestDTO dto,byte[] pdfBytes) {
		
		final String fromEmail= "your-email@gmail.com";
		final String password = "your-app-password";
		
		
		
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smpt.starttls.enable", "true");
		
		
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(fromEmail,password);
			}
			
		});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(dto.getTo()) );
			message.setSubject(dto.getSubject());
			message.setText(dto.getBody());
			
			MimeBodyPart mesageBodyPart = new MimeBodyPart();
			mesageBodyPart.setText(dto.getBody());
			
			MimeBodyPart attachmentPart = new MimeBodyPart();
			DataSource dataSource = new ByteArrayDataSource(pdfBytes,"application/pdf");
			attachmentPart.setDataHandler(new DataHandler(dataSource));
			attachmentPart.setFileName("invoice.pdf");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mesageBodyPart);
			multipart.addBodyPart(attachmentPart);
			
			message.setContent(multipart);
			
			Transport.send(message);
			System.out.println("Email sent to"+dto.getTo());
			System.out.println("Invoice sent to"+dto.getTo());
			
			
		} catch (MessagingException e) {
			throw new RuntimeException("Failed to send Email" , e);
			
		}
	}

}

