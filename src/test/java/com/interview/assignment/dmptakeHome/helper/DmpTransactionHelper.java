package com.interview.assignment.dmptakeHome.helper;

import com.interview.assignment.dmptakeHome.model.Transaction;
import com.interview.assignment.dmptakeHome.model.TransactionDto;
import com.interview.assignment.dmptakeHome.model.TransactionResponse;

public class DmpTransactionHelper {

    public static TransactionDto getTransactionRequest() {
        TransactionDto transactionDto = new TransactionDto();
        Transaction transaction = new Transaction();
        transaction.setAmount(21.00);
        transaction.setCardNum(123456789L);
        transactionDto.setTransaction(transaction);
        return transactionDto;

    }

    public static TransactionDto getTransactionRequestBeyondMaxLimit() {
        TransactionDto transactionDto = new TransactionDto();
        Transaction transaction = new Transaction();
        transaction.setAmount(51000.00);
        transaction.setCardNum(123456789L);
        transactionDto.setTransaction(transaction);
        return transactionDto;

    }

    public static TransactionResponse getTransactionResponseForApprovedTransaction() {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setStatus(true);
        transactionResponse.setCardUsageCount(21);
        transactionResponse.setCardNumber(123456789L);
        transactionResponse.setTransactionAmount(51.00);
        return transactionResponse;
    }

    public static TransactionResponse getTransactionResponseForDeclinedTransaction() {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setStatus(false);
        transactionResponse.setCardUsageCount(21);
        transactionResponse.setCardNumber(123456789L);
        transactionResponse.setTransactionAmount(51.00);
        return transactionResponse;
    }
}
