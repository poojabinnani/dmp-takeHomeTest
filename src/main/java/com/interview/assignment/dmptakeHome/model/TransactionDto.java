/*
package com.interview.assignment.dmptakeHome.model;

import lombok.Data;

import java.util.List;

@Data
public class TransactionDto {

    private long cardNumber;

    private long transactionAmount;

    String title;
    String type;
    List<String> required;
    Properties properties;
}
*/

package com.interview.assignment.dmptakeHome.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * root
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "transaction"
})
@Generated("jsonschema2pojo")
public class TransactionDto implements Serializable
{

    /**
     * transaction
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("transaction")
    @Valid
    @NotNull
    private Transaction transaction;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private final static long serialVersionUID = 6215830634527923176L;

    /**
     * No args constructor for use in serialization
     *
     */
    public TransactionDto() {
    }

    /**
     * transaction
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("transaction")
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * transaction
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("transaction")
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transaction");
        sb.append('=');
        sb.append(((this.transaction == null)?"<null>":this.transaction));
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
