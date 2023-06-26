package com.interview.assignment.dmptakeHome.controller;

import com.interview.assignment.dmptakeHome.exceptions.ApiRequestException;
import com.interview.assignment.dmptakeHome.model.TransactionResponse;
import com.interview.assignment.dmptakeHome.model.TransactionDto;
import com.interview.assignment.dmptakeHome.service.DmpTakeHomeApplicationService;
import com.interview.assignment.dmptakeHome.utils.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pooja Mahehswari poojamaheshwari72@gmail.com
 * DmpTakeHomeApplicationController class to handle rest API for validating transaction
 */
@RestController
@RequestMapping(path ="/analyzeTransaction",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Slf4j
public class DmpTakeHomeApplicationController {

    @Autowired
    private DmpTakeHomeApplicationService dmpTakeHomeApplicationService;


    /**
     * Method will analyze transaction and validate it
     * @param transactionDto transactionDto object.
     * @return TransactionResponse transactionResponse
     */
    @PostMapping(consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransactionResponse> validateTransaction(@Valid @RequestBody TransactionDto transactionDto) throws ApiRequestException {
        log.info("Value of request body is {}", transactionDto);
        Validator.validateMethodArgument(transactionDto);
        return dmpTakeHomeApplicationService.validateTransaction(transactionDto);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApiRequestException.class)
    public TransactionResponse handleValidationExceptions(ApiRequestException ex) {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setErrorMessage(ex.getMessage());
        return transactionResponse;
    }

}
