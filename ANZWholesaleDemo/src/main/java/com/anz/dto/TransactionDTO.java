package com.anz.dto;



import com.anz.entity.AccountTransactionEntity;

public class TransactionDTO {
	
	private long accountNumber;

	private String accountName;

	private String valueDate;

	private String currency;

	private double debitAmount;
	
	private double creditAmount;

	private String transactionType;

	public TransactionDTO() {

	}


	

	public long getAccountNumber() {
		return accountNumber;
	}




	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}




	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	
	
	public static TransactionDTO prepareDTO(AccountTransactionEntity transactionEntity) {
		TransactionDTO transactionDto = new TransactionDTO();
		transactionDto.setAccountName(transactionEntity.getAccountName());
		transactionDto.setAccountNumber(transactionEntity.getAccountNumber());
		transactionDto.setCurrency(transactionEntity.getCurrency());
		transactionDto.setDebitAmount(transactionEntity.getDebitAmount());
		transactionDto.setCreditAmount(transactionEntity.getCreditAmount());
		transactionDto.setTransactionType(transactionEntity.getTransactionType());
		transactionDto.setValueDate(transactionEntity.getValueDate());
		return transactionDto;
	}


	public static AccountTransactionEntity prepareEntity(TransactionDTO  transactionDTO ) {
		AccountTransactionEntity transactionEntity = new AccountTransactionEntity();
		transactionEntity.setAccountName(transactionDTO.getAccountName());
		transactionEntity.setAccountNumber(transactionDTO.getAccountNumber());
		transactionEntity.setCurrency(transactionDTO.getCurrency());
		transactionEntity.setDebitAmount(transactionDTO.getDebitAmount());
		transactionEntity.setCreditAmount(transactionDTO.getCreditAmount());
		transactionEntity.setTransactionType(transactionDTO.getTransactionType());
		transactionEntity.setValueDate(transactionDTO.getValueDate());
		return transactionEntity;
	}


	@Override
	public String toString() {
		return "TransactionDTO [accountNumber=" + accountNumber + ", accountName=" + accountName + ", valueDate="
				+ valueDate + ", currency=" + currency + ", debitAmount=" + debitAmount + ", creditAmount="
				+ creditAmount + ", transactionType=" + transactionType +  "]";
	}


}
