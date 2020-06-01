package com.anz.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.dto.AccountDTO;
import com.anz.dto.TransactionDTO;
import com.anz.entity.AccountListEntity;
import com.anz.entity.AccountTransactionEntity;
import com.anz.exception.NoAccountExistException;
import com.anz.exception.NoTransactionExistException;
import com.anz.repository.AccountListRepo;
import com.anz.repository.TransactionRepo;
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	public AccountListRepo accountRepo;
	
	@Autowired
	public TransactionRepo transactionRepo;
    
	
	//method fetch the list of Account detail for the given loginId.
	@Override
	public List<AccountDTO> viewAccountDetail(String loginId) throws Exception {
		List<AccountListEntity> accountEntityList = accountRepo.findByLoginId(loginId);

		if (accountEntityList.isEmpty()) {
			throw new NoAccountExistException("Account does not exist");}
		List<AccountDTO> accountDTO = new ArrayList<AccountDTO>();
		for (AccountListEntity accountEntity : accountEntityList) {
			accountDTO.add(AccountDTO.prepareDTO(accountEntity));
		}

		return accountDTO;
	}
	
	//method fetch the list of transaction summary for the given accountNo.
	@Override
	public List<TransactionDTO> viewTransactionDetail(Long accountNumber) throws Exception {
		List<AccountTransactionEntity> transactionEntityList = transactionRepo.findByAccountNumber(accountNumber);

		if (transactionEntityList.isEmpty())
			throw new NoTransactionExistException("No transaction summary found for this account");

		List<TransactionDTO> transactionDTO = new ArrayList<TransactionDTO>();

		for (AccountTransactionEntity transactionEntity : transactionEntityList) {
			transactionDTO.add(TransactionDTO.prepareDTO(transactionEntity));
		}

		return transactionDTO;

	}

	// method used to create account for the given loginId
	@Override
	public String createAccount(AccountDTO accountDTO) throws Exception{
		accountRepo.save(AccountDTO.prepareEntity(accountDTO));
		if (accountRepo.findByAccountNumber(accountDTO.getAccountNumber()) ==null)
		     throw new Exception("Account Already Exist");
		return "Successfully added"; 
	}

	// method used to 
	@Override
	public String makeTransaction(TransactionDTO transactionDTO)  {
		transactionRepo.save(TransactionDTO.prepareEntity(transactionDTO));
		return "Successfully added"; 
	}
     


}
