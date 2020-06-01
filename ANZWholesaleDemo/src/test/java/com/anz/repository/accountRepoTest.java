package com.anz.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.anz.dto.AccountDTO;
import com.anz.entity.AccountListEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class accountRepoTest {
	 @Mock 
	 private AccountListRepo accountRepo;
	 
	 private AccountDTO account1;
	 private List<AccountDTO> accountList=null;
	 private long dummyAcctNo=11111111;
	 private String dummyValue="dummy";
	 private double dummyBalance=0.15;
	 

	 public void account1() {
		 account1= new AccountDTO();
		 account1.setAccountNumber(dummyAcctNo);
		 account1.setAccountName(dummyValue);
		 account1.setAccountType(dummyValue);
		 account1.setCurrency(dummyValue);
		 account1.setLoginId(dummyValue);
		 account1.setBalanceDate(dummyValue);
		 account1.setOpeningAvailableBalance(dummyBalance);
         accountList =new ArrayList<>();
         accountList.add(account1);
	 }
	 
	 @Before
	 public void setUp() {
		 account1();
     }
	 
	 @Test
	 public void saveTest() {
		
		 AccountListEntity accountEntity= new AccountListEntity();
		 accountEntity.setAccountNumber(account1.getAccountNumber());
		 accountEntity.setAccountName(account1.getAccountName());
		 accountEntity.setAccountType(account1.getAccountType());
		 accountEntity.setLoginId(account1.getLoginId());
		 accountEntity.setCurrency(account1.getCurrency());
		 accountEntity.setBalanceDate(account1.getBalanceDate());
		 accountEntity.setOpeningAvailableBalance(account1.getOpeningAvailableBalance());
		 
		 Mockito.when(accountRepo.save(accountEntity)).thenReturn(accountEntity);
		 AccountListEntity accountListEntity = accountRepo.save(accountEntity);
			assertThat(accountListEntity).hasFieldOrPropertyWithValue("loginId", "dummy");
		 
		 
		 
	 }
	 
//	 @Test
//		public void findByLoginIdTest() {
//		 List < AccountListEntity> accountList=new ArrayList<>();
//		 AccountListEntity accountEntity= new AccountListEntity();
//		 accountEntity.setAccountNumber(account1.getAccountNumber());
//		 accountEntity.setAccountName(account1.getAccountName());
//		 accountEntity.setAccountType(account1.getAccountType());
//		 accountEntity.setLoginId(account1.getLoginId());
//		 accountEntity.setCurrency(account1.getCurrency());
//		 accountEntity.setBalanceDate(account1.getBalanceDate());
//		 accountEntity.setOpeningAvailableBalance(account1.getOpeningAvailableBalance());
//		 
//			Mockito.when(accountRepo.findByLoginId(account1.getLoginId())).thenReturn(accountList);
//			List<AccountListEntity> accountListEntity= accountRepo.findByLoginId(account1.getLoginId());
//			assertThat(accountListEntity).anyMatch(account1.getLoginId().matches("dummy"));
//			}
	

}
