package com.adulttoy.bankapp.controller;

import com.adulttoy.bankapp.exception.BadRequestException;
import com.adulttoy.bankapp.request.CreateTransactionRequest;
import com.adulttoy.bankapp.response.CreateTransactionResponse;
import com.adulttoy.bankapp.service.abstractions.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.adulttoy.bankapp.configuration.Constants;

@RestController
@RequestMapping(value="/transaction", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;





	@PostMapping("/create")
	public CreateTransactionResponse createTransaction(@RequestBody CreateTransactionRequest request) {



		CreateTransactionResponse response = new CreateTransactionResponse();

		return response;
	}


}
