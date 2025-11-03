package com.set_job_portal.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.set_job_portal.DTO.PaymentRequestDTO;
import com.set_job_portal.DTO.PaymentResponseDTO;
import com.set_job_portal.Entity.Payment;
import com.set_job_portal.Enum.PaymentStatus;
import com.set_job_portal.Repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService 
{
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	
	public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {
		Payment pay = new Payment();
		pay.setUserId(dto.getUserId());
		pay.setPlanId(dto.getPlanId());
		pay.setAmount(dto.getAmount());
		pay.setPaymentStatus(PaymentStatus.SUCCESS);
		pay.setTransactionId(UUID.randomUUID().toString());
		pay.setTimeStamp(LocalDateTime.now());
		
		paymentRepo.save(pay);
		
		byte[] pdfBytes = invoiceService.generateInvoice(pay);
		
		MultiValueMap<String, Object> payload = new LinkedMultiValueMap<>();
		payload.add("to", "user@gmail.com"); //Replace with real user Email
		payload.add("subject", "Your ZIDIOConnect Invoice");
		payload.add("body", "Dear User,\n\nThank You for your payment,please find your invoice"); 
		payload.add("pdfBytes", Base64.getEncoder().encodeToString(pdfBytes));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(payload);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(
				"http://localhost:8080/api/notify/send-invoice", requestEntity, String.class);
		
		PaymentResponseDTO response = new PaymentResponseDTO();
		response.setTransactionId(pay.getTransactionId());
		response.setPaymentStatus(pay.getPaymentStatus());
		response.setAmount(pay.getAmount());
		return response;
	}


}
