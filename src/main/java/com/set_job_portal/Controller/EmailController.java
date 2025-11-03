package com.set_job_portal.Controller;

import java.io.File;
import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.set_job_portal.DTO.EmailRequestDTO;
import com.set_job_portal.Service.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class EmailController 
{
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<String>sendEmail(@RequestBody EmailRequestDTO dto ){
		emailService.sendEmail(dto,null);
		return ResponseEntity.ok("Email sent successfully");
	}
//	@PostMapping("/send-Invoice")
//	public ResponseEntity<String>sendInvoice(@RequestParam String to
//			,@RequestParam String subject
//			,@RequestParam String body
//			,@RequestParam String filePath)
//	{
//		emailService.sendEmail(new EmailRequestDTO(to,subject,body), new File(filePath));
//		return ResponseEntity.ok("Invoice Email Sent Successfully");
//	}
	
	
	@PostMapping("/send-Invoice")
	public String sendInvoice(@RequestBody Map<String, String> payload)
	{
		String to = payload.get("to");
		String subject = payload.get("subject");
		String body = payload.get("body");
		String pdfBase64 = payload.get("pdfBase64");
		
//		Convert Base64 back to byte[]
		byte[] pdfBytes = Base64.getDecoder().decode(pdfBase64);
		
		EmailRequestDTO request = new EmailRequestDTO(to, subject, body);
		emailService.sendEmail(request, pdfBytes);
		
		return "Invoice Email Sent Successfully";
		
	}
	
	
}
