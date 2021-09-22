package com.dbs.dao;

import lombok.Data;

@Data
public class TransactionRequest {

String senderName;
	String senderAccountNumber;
	String recipientBic;
	double amount;
	
}
