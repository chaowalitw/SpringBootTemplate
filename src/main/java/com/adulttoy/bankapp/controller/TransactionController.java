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

		if (request.getUsername() == null || request.getUsername().equals("")) {
			throw new BadRequestException(Constants.MESSAGE_INVALIDUSERNAME);
		} else if (request.getCurrency() == null || request.getCurrency().equals("")) {
			throw new BadRequestException(Constants.MESSAGE_INVALIDCURRENCY);
		} else if (request.getAmount() == null || request.getAmount().signum() == 0 || request.getAmount().signum() == -1) {
			throw new BadRequestException(Constants.MESSAGE_INVALIDAMOUNT);
		} else if (request.getCurrency().equals(Constants.MAIN_CURRENCY)) {
			throw new BadRequestException(Constants.MESSAGE_EXCHANGESWITHMAINCURRENCY);
		}

		/*User user = userService.findByUserName(request.getUsername());

		int last24HoursOperationCount = transactionService.getOperationCountFromLast24Hours(user.getId());
		if (last24HoursOperationCount >= 10) {
			throw new DailyOperationLimitReachedException();
		}

		wealthService.makeWealthExchange(user.getId(), request.getCurrency(), request.getAmount(), request.isBuying());
		Transaction transaction = transactionService.createNewTransaction(user.getId(), request.isBuying(), request.getCurrency(), request.getAmount());
*/
		CreateTransactionResponse response = new CreateTransactionResponse();
	//	response.setTransaction(transaction);
		return response;
	}

	/*@PostMapping("/find/all")
	public FindAllTransactionsByUserResponse findAll(@RequestBody FindAllTransactionsByUserRequest request) {

		if (request.getUsername() == null || request.getUsername().equals("")) {
			throw new BadRequestException(Constants.MESSAGE_INVALIDUSERNAME);
		}

	//	User user = userService.findByUserName(request.getUsername());
	//	List<Transaction> transactionList = transactionService.findAllByUserId(user.getId());

	//	FindAllTransactionsByUserResponse response = new FindAllTransactionsByUserResponse();
	//	response.setTransactionList(transactionList);
		return response;
	}*/

}
