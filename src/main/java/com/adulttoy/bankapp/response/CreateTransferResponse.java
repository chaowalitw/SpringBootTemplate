package com.adulttoy.bankapp.response;

import com.adulttoy.bankapp.model.Transfer;

import lombok.Data;

@Data
public class CreateTransferResponse {
	private Transfer transfer;
}
