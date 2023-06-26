package com.interview.assignment.dmptakeHome.service;

import com.interview.assignment.dmptakeHome.client.RandomServiceClient;
import com.interview.assignment.dmptakeHome.helper.DmpTransactionHelper;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DmpTakeHomeApplicationTests {

	@Autowired
	private DmpTakeHomeApplicationImpl dmpTakeHomeApplicationMock;

	@MockBean
	RandomServiceClient randomServiceClient;

	@Test
	void validateTransactionTestCountBreached() {
		Mockito.when(randomServiceClient.getTransactionByDay()).thenReturn(new String[]{"1", "10", "15", "20", "25", "30", "35"});
		Assertions.assertNotNull(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequest()));
		Assertions.assertFalse(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequest()).getBody().isStatus());
	}

	@Test
	void validateTransactionTestAmountBreached() {
		Mockito.when(randomServiceClient.getTransactionByDay()).thenReturn(new String[]{"5", "4", "3", "6", "5", "6", "7"});
		Assertions.assertNotNull(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequestBeyondMaxLimit()));
		Assertions.assertFalse(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequestBeyondMaxLimit()).getBody().isStatus());
	}

	@Test
	void validateTransactionTestIrregularTransaction() {
		Mockito.when(randomServiceClient.getTransactionByDay()).thenReturn(new String[]{"1", "2", "3", "1", "1", "1", "1"});
		Assertions.assertNotNull(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequestBeyondMaxLimit()));
		Assertions.assertFalse(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequestBeyondMaxLimit()).getBody().isStatus());
	}

	@Test
	void validateTransactionTestApproved() {
		Mockito.when(randomServiceClient.getTransactionByDay()).thenReturn(new String[]{"5", "5", "5", "6", "6", "6", "5"});
		Assertions.assertNotNull(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequest()));
		Assertions.assertTrue(dmpTakeHomeApplicationMock.validateTransaction(DmpTransactionHelper.getTransactionRequest()).getBody().isStatus());
	}

}
