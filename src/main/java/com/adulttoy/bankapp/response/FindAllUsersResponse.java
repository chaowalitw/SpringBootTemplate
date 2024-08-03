package com.adulttoy.bankapp.response;

import java.util.List;

import com.adulttoy.bankapp.model.User;

import lombok.Data;

@Data
public class FindAllUsersResponse {
	List<User> userList;
}
