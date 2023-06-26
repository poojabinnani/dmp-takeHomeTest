package com.interview.assignment.dmptakeHome.utils;

import com.interview.assignment.dmptakeHome.exceptions.ApiRequestException;
import com.interview.assignment.dmptakeHome.model.TransactionDto;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class Validator {
    public static void validateMethodArgument(TransactionDto transactionDto) throws ApiRequestException {

        if (transactionDto == null || transactionDto.getTransaction() == null) {
            throw new ApiRequestException("Request body cannot be null");
        }
        if (transactionDto.getTransaction().getCardNum() < 1000000000000000L) {
            throw new ApiRequestException("Card number cannot be less than 1000000000000000");
        }
        if (transactionDto.getTransaction().getCardNum() > 9999999999999999L) {
            throw new ApiRequestException("Card number cannot be less than 9999999999999999");
        }
        if (transactionDto.getTransaction().getAmount() < 0.0) {
            throw new ApiRequestException("Transaction amount cannot be negative");
        }
    }
}
