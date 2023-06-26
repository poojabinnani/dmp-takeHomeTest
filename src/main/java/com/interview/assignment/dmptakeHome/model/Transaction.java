
package com.interview.assignment.dmptakeHome.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


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
    @DecimalMin("1000000000000000")
    @DecimalMax("9999999999999999")
    @NotNull
    @Valid
    private Long cardNum = 9999999999999999L;
    /**
     * amount
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    @NotNull
    private Double amount = 0.0D;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
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
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
