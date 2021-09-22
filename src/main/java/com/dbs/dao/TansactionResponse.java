package com.dbs.dao;

import lombok.Data;

@Data
public class TansactionResponse {

	boolean isSuccessful;
	public String transferType;
	String clearBalance;
	
}
