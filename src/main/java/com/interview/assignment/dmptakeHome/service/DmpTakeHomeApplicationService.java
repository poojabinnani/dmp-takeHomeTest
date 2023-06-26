package com.interview.assignment.dmptakeHome.service;

import com.interview.assignment.dmptakeHome.model.TransactionResponse;
import com.interview.assignment.dmptakeHome.model.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * DmpTakeHomeApplicationService class is used as the service class for mapping requests
 */
@Service
public interface DmpTakeHomeApplicationService {

    /**
     * Method to validate analyze and validate transaction
     * @param  transactionDto transactionDto object
     * @return TransactionResponse transactionResponse
     */
    ResponseEntity<TransactionResponse> validateTransaction(TransactionDto transactionDto);
}
