package com.interview.assignment.dmptakeHome.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * This class is used as a model class for transaction
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionResponse implements Serializable {

    private boolean status;

    private Long cardNumber;

    private Double transactionAmount;

    private int cardUsageCount;

    private String errorMessage;
}
