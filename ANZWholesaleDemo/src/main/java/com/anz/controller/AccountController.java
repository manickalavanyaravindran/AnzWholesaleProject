package com.anz.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anz.dto.AccountDTO;
import com.anz.dto.TransactionDTO;
import com.anz.service.AccountService;

@Controller
@ResponseBody
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/accounts/view")
	public List<AccountDTO> getAccountList(@RequestParam("loginId") String loginId) throws Exception {
		return accountService.viewAccountDetail(loginId);
	}

	@GetMapping("/transactions/get")
	public List<TransactionDTO> getTransactionDetail(@RequestParam("accountNumber") Long accountNumber) throws Exception {
		return accountService.viewTransactionDetail(accountNumber);
	}
	@PostMapping("/accounts")
	public String createAccount(@RequestBody AccountDTO accountDTO) throws Exception {
		return accountService.createAccount(accountDTO);
	}
	@PostMapping("/transactions")
	public String makeTransaction(@RequestBody TransactionDTO transactionDTO)  {
		return accountService.makeTransaction(transactionDTO);
	}
	

}
