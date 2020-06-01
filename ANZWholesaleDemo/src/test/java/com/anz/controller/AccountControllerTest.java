package com.anz.controller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.anz.dto.AccountDTO;
import com.anz.dto.TransactionDTO;
import com.anz.repository.AccountListRepo;
import com.anz.repository.TransactionRepo;
import com.anz.service.AccountService;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers=AccountController.class)
public class AccountControllerTest {

	
	
	 @Autowired
	 private  MockMvc mockMVC;
	 
	 
	 @MockBean
	 private AccountListRepo accountRepo;
	 
	 @MockBean
	 private TransactionRepo transactionRepo;
	 
	 @MockBean
	 private AccountService accountService;
	 
	 @InjectMocks
	 private AccountController accountController;
	 
	 
	 private List<AccountDTO> accountList=null;
	 private List<TransactionDTO> transactionList=null;
	 private AccountDTO account1;
	 
	 private TransactionDTO transaction1;
	 
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
	 
	 public void transaction1() {
		 transaction1= new TransactionDTO();
		 transaction1.setAccountNumber(dummyAcctNo);
		 transaction1.setAccountName(dummyValue);
		 transaction1.setTransactionType("Credit");
		 transaction1.setCurrency("USD");
		 transaction1.setCreditAmount(8000);
		 transaction1.setValueDate("08/11/2018");
		 transaction1.setDebitAmount(0);
		 transactionList= new ArrayList<>();
		 transactionList.add(transaction1);

	 }
	 
	 @Before
	 public void setUp() {
		 account1();
		 transaction1();
	 }
	 

	 
	 @Test
	 public void testCreateAccount() throws Exception{
		      // setting behavior for createAccount of accountService that is mocked
			Mockito.when(accountService.createAccount(Mockito.any(AccountDTO.class)))
					.thenReturn(account1.getLoginId() + "added successfully");
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			// Send Account detail as request body to /account
			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account").accept(MediaType.APPLICATION_JSON)
					.content(mapper.writeValueAsBytes(account1)).contentType(MediaType.APPLICATION_JSON);
			MvcResult result = mockMVC.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			Assert.assertEquals("dummyadded successfully", response.getContentAsString());
			Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		 
	 }
	 
	 @Test
	 public void testCreateTransaction() throws Exception{
		      // setting behavior for createTRansaction of accountService that is mocked
			Mockito.when(accountService.makeTransaction(Mockito.any(TransactionDTO.class)))
					.thenReturn(transaction1.getAccountNumber() + "added successfully");
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			// Send Transaction detail as request body to /account
			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transaction").accept(MediaType.APPLICATION_JSON)
					.content(mapper.writeValueAsBytes(transaction1)).contentType(MediaType.APPLICATION_JSON);
			MvcResult result = mockMVC.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			Assert.assertEquals("11111111added successfully", response.getContentAsString());
			Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		 
	 }
	 
	 @Test
		public void getAccountListTest() throws Exception {
			Mockito.when(accountService.viewAccountDetail(dummyValue)).thenReturn(accountList);
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts").param("loginId","dummy");
			MvcResult result = mockMVC.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			ObjectMapper mapper = new ObjectMapper();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			mapper.writeValue(out, accountList);
			byte[] data = out.toByteArray();
			Assert.assertEquals(new String(data), response.getContentAsString());
		}
	 @Test
		public void getTransactionDetailTest() throws Exception {
			Mockito.when(accountService.viewTransactionDetail(dummyAcctNo)).thenReturn(transactionList);
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions").param("accountNumber","11111111");
			MvcResult result = mockMVC.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			ObjectMapper mapper = new ObjectMapper();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			mapper.writeValue(out, transactionList);
			byte[] data = out.toByteArray();
			Assert.assertEquals(new String(data), response.getContentAsString());
		}
	 
}
