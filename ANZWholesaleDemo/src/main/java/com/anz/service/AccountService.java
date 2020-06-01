package com.anz.service;

import java.util.List;

import com.anz.dto.AccountDTO;
import com.anz.dto.TransactionDTO;

public interface AccountService {
	public List<AccountDTO> viewAccountDetail(String loginId) throws Exception;

	public List<TransactionDTO> viewTransactionDetail(Long accountNumber) throws Exception;
	
	public String createAccount(AccountDTO accountDTO) throws Exception;

	public String makeTransaction(TransactionDTO transactionDTO);

}
