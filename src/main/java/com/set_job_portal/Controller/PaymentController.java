package com.set_job_portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.set_job_portal.DTO.PaymentRequestDTO;
import com.set_job_portal.DTO.PaymentResponseDTO;
import com.set_job_portal.Entity.Payment;
import com.set_job_portal.Entity.Subscriptionplan;
import com.set_job_portal.Repository.PaymentRepository;
import com.set_job_portal.Repository.SubscriptionPlanRepository;
import com.set_job_portal.Service.InvoiceService;
import com.set_job_portal.Service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController
{
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private SubscriptionPlanRepository subPlanRepo;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@PostMapping("/process")
	public ResponseEntity<PaymentResponseDTO>process(@RequestBody PaymentRequestDTO dto ){
		return ResponseEntity.ok(paymentService.processPayment(dto));
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Subscriptionplan>>getPlans(){
		return ResponseEntity.ok(subPlanRepo.findAll());
	}
	@PostMapping ResponseEntity<Subscriptionplan>createPlans(@RequestBody Subscriptionplan plan){
		return ResponseEntity.ok(subPlanRepo.save(plan));
	}
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Payment>>history(@PathVariable Long userId){
    	return ResponseEntity.ok(paymentRepo.findByUserId(userId));
    }
	
	
    @GetMapping("/invoice/{paymentId}")
	public ResponseEntity<byte[]>downloadInvoice(@PathVariable Long paymentId){
		
		Payment pay = paymentRepo.findById(paymentId).orElseThrow(()-> new RuntimeException("Payment not found"));
		byte[] pdfBytes =  invoiceService.generateInvoice(pay);
		
		return ResponseEntity.ok()
				.header("Content-Diposition", "Attachment; fileNameInvoice-" +pay.getTransactionId() + ".pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(pdfBytes);
	}
	
	

}
