package com.adulttoy.bankapp.response;

import java.util.List;

import com.adulttoy.bankapp.model.Transaction;

import lombok.Data;

@Data
public class FindAllTransactionsByUserResponse {
	private List<Transaction> transactionList;
}
