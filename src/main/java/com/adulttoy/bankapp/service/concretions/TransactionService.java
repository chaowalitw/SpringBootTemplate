package com.adulttoy.bankapp.service.concretions;

import java.math.BigDecimal;
import java.util.List;

import com.adulttoy.bankapp.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adulttoy.bankapp.repository.TransactionRepository;
import com.adulttoy.bankapp.service.abstractions.ITransactionService;

@Service
public class TransactionService implements ITransactionService {

	private TransactionRepository repository;

	@Autowired
	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}


}
