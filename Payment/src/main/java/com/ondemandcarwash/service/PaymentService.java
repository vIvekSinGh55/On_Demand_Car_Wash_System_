package com.ondemandcarwash.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondemandcarwash.model.Payments;
import com.ondemandcarwash.repository.PaymentRepository;

@Service
public class PaymentService 
{
	@Autowired
    private PaymentRepository repository;
	
	@Autowired
	private Random random;

    public Payments doPay(Payments payment)
    {
        payment.setPaymentStatus(paymentStatus());
        payment.setTxId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    private String paymentStatus(){
    	
        return this.random.nextBoolean()?"success":"failure";
    }
}
