
package com.interview.assignment.dmptakeHome.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * transaction
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardNum",
    "amount"
})
@Generated("jsonschema2pojo")
public class Transaction implements Serializable
{

    /**
     * cardnum
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("cardNum")
    @DecimalMin(value = "1000000000000000", message = "Card number cannot be less than 1000000000000000")
    @DecimalMax(value = "9999999999999999", message = "Card number cannot be greater than 9999999999999999")
    @NotNull(message = "Card number is mandatory")
    private Long cardNum = 9999999999999999L;
    /**
     * amount
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    @NotNull(message = "Transaction amount is mandatory")
    private Double amount = 0.0D;

    private final static long serialVersionUID = -6747408796958578611L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Transaction() {
    }


    /**
     * cardnum
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("cardNum")
    public Long getCardNum() {
        return cardNum;
    }

    /**
     * cardnum
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("cardNum")
    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }


    /**
     * amount
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    /**
     * amount
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Transaction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":getMaskedCardNumber(this.cardNum)));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    private String getMaskedCardNumber(Long cardNum) {
        String cardNumberInString = String.valueOf(cardNum);
        int numberOfInitialCharsNotToMask = 4;
        int numberOfEndCharsNotToMask = 4;
        // index 4-11
        String innerString = cardNumberInString.substring(numberOfInitialCharsNotToMask, cardNumberInString.length()-numberOfEndCharsNotToMask);
        innerString = innerString.replaceAll("[0-9]", "*");
        //index 0-3 + 4-11 + 12-15
        return cardNumberInString.substring(0, numberOfInitialCharsNotToMask) +  innerString + cardNumberInString.substring(cardNumberInString.length()-numberOfEndCharsNotToMask, cardNumberInString.length());
    }

}
