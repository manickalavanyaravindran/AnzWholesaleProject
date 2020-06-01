package com.anz.dto;

import com.anz.entity.AccountListEntity;

public class AccountDTO {

	
    private long accountNumber;
	
	private String accountName;
	
	private String accountType;
	
	private String balanceDate;

	private String currency;

	private double openingAvailableBalance;
	
	private String loginId; 
	
	public AccountDTO() {

	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(double openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}
	
	
	
	@Override
	public String toString() {
		return "AccountDTO [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountType="
				+ accountType + ", balanceDate=" + balanceDate + ", currency=" + currency + ", openingAvailableBalance="
				+ openingAvailableBalance + ", loginId=" + loginId + "]";
	}

	public static AccountDTO prepareDTO(AccountListEntity accountEntity) {
		AccountDTO accountDTO= new AccountDTO();
		accountDTO.setAccountNumber(accountEntity.getAccountNumber());
		accountDTO.setAccountName(accountEntity.getAccountName());
		accountDTO.setAccountType(accountEntity.getAccountType());
		accountDTO.setCurrency(accountEntity.getCurrency());
		accountDTO.setBalanceDate(accountEntity.getBalanceDate());
		accountDTO.setOpeningAvailableBalance(accountEntity.getOpeningAvailableBalance());
		accountDTO.setLoginId(accountEntity.getLoginId());
		return accountDTO;
	}
	
	public static AccountListEntity prepareEntity(AccountDTO accountDTO) {
		AccountListEntity accountEntity=new AccountListEntity();
		accountEntity.setAccountNumber(accountDTO.getAccountNumber());
		accountEntity.setAccountName(accountDTO.getAccountName());
		accountEntity.setAccountType(accountDTO.getAccountType());
		accountEntity.setBalanceDate(accountDTO.getBalanceDate());
		accountEntity.setCurrency(accountDTO.getCurrency());
		accountEntity.setLoginId(accountDTO.getLoginId());
		accountEntity.setOpeningAvailableBalance(accountDTO.getOpeningAvailableBalance());
		return accountEntity;
		
	}
}
