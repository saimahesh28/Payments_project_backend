package com.dbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.dao.TansactionResponse;
import com.dbs.dao.TransactionRequest;
import com.dbs.entity.Customer;
import com.dbs.repository.CustomerRepository;
import com.dbs.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	CustomerRepository customerRepository;
	
	ResponseEntity<Object> sendMoney(TransactionRequest transactionRequest)
	{
//		Customer sender;
		
		if(transactionRequest.getAmount()<0) {
			
		}
		if(transactionRequest.getRecipientBic().isEmpty())
		{
			
		}
		
		
		double total=1.25*(transactionRequest.getAmount());
		if(total>customerRepository.findById(transactionRequest.getSenderAccountNumber()).get().getClearBalance())
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("amount cant be more than balance");
		}
		
		
		
		Customer sender=customerRepository.findById(transactionRequest.getSenderAccountNumber()).get();
		TansactionResponse transactionResponse=new TansactionResponse();
		if(sender.getCustomerName().toUpperCase().contains("BANK"))
		{
			transactionResponse.setTransferType("BB");
		}
//		if() {
//			//check if recipient name is present in sdn list
//			
//		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("transaction successful");
	}
	
	
}
