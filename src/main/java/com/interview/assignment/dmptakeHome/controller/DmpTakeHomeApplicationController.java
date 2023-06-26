package com.interview.assignment.dmptakeHome.controller;

import com.interview.assignment.dmptakeHome.model.TransactionResponse;
import com.interview.assignment.dmptakeHome.model.TransactionDto;
import com.interview.assignment.dmptakeHome.service.DmpTakeHomeApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<TransactionResponse> validateTransaction(@RequestBody @Valid TransactionDto transactionDto) {
        log.info("Value of request body is {}", transactionDto);
        return dmpTakeHomeApplicationService.validateTransaction(transactionDto);
    }

}
