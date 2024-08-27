package com.adulttoy.bankapp.controller;

import com.adulttoy.bankapp.configuration.Constants;
import com.adulttoy.bankapp.exception.BadRequestException;
import com.adulttoy.bankapp.request.CreateTransactionRequest;
import com.adulttoy.bankapp.response.CreateTransactionResponse;
import com.adulttoy.bankapp.service.abstractions.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

	@RequestMapping(value="/test", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> createTransaction() {

				return ResponseEntity.ok("xxxx");
	}



}
