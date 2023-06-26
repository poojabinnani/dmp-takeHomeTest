package com.interview.assignment.dmptakeHome.service;

import com.interview.assignment.dmptakeHome.client.RandomServiceClient;
import com.interview.assignment.dmptakeHome.model.TransactionDto;
import com.interview.assignment.dmptakeHome.model.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the Implementation class for DmpTakeHomeApplicationService.
 */
@Service
@Slf4j
public class DmpTakeHomeApplicationImpl implements DmpTakeHomeApplicationService {

    @Autowired
    private RandomServiceClient randomServiceClient;
    @Value("${validation.transaction.max.amount}")
    public  int maxTransactionLimit ;
    @Value("${validation.transaction.max.count}")
    public  int maxTransactionCount ;
    @Value("${validation.transaction.min.count}")
    public  int minTransactionCount ;
    @Value("${validation.transaction.threshold.amount}")
    public int thresholdAmount;

    /**
     * @param transactionDto transactionDto Object
     * @return transactionResponse
     *
     */
    @Override
    public ResponseEntity<TransactionResponse> validateTransaction(TransactionDto transactionDto) {
        List<String> usageCountInSevenDays = Arrays.stream(randomServiceClient.getTransactionByDay()).collect(Collectors.toList());
        int totalUsageCount = 0;
        for (int i = 0; i < usageCountInSevenDays.size(); i++)
            totalUsageCount += Integer.parseInt(usageCountInSevenDays.get(i));
        TransactionResponse transactionResponse = setTransactionResponse(transactionDto, totalUsageCount);

        if (isTransactionAmountNotAllowed(transactionDto)
                || isTransactionCountBreached(totalUsageCount)
                || isTransactionIrregular(transactionDto, totalUsageCount)) {
            log.warn("Transaction is declined");
            transactionResponse.setStatus(false);
        } else {
            transactionResponse.setStatus(true);
            log.info("Transaction is Approved");
        }

        return new ResponseEntity<>(transactionResponse,HttpStatus.OK) ;
    }

    /**
     * This method checks for irregular transactions
     * @param transactionDto transacionDto object
     * @param totalUsageCount totalUsageCount os transactions
     * @return Boolean value
     */
    private  boolean isTransactionIrregular(TransactionDto transactionDto, int totalUsageCount) {
        return (totalUsageCount < minTransactionCount)
                && transactionDto.getTransaction().getAmount() / totalUsageCount > thresholdAmount;
    }

    /**
     * This method checks if transaction count has exceeded the threshold limit
     * @param totalUsageCount total number of transactions
     * @return boolean status
     */
    private  boolean isTransactionCountBreached(int totalUsageCount) {
        return totalUsageCount > maxTransactionCount;
    }

    /**
     * This method checks if transaction amount has exceeded the threshold limit
     * @param transactionDto total number of transactions
     * @return boolean status
     */
    private boolean isTransactionAmountNotAllowed(TransactionDto transactionDto) {
        return transactionDto.getTransaction().getAmount() > maxTransactionLimit;
    }


    private static TransactionResponse setTransactionResponse(TransactionDto transactionDto, int totalUsageCount) {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionAmount(transactionDto.getTransaction().getAmount());
        transactionResponse.setCardUsageCount(totalUsageCount);
        transactionResponse.setCardNumber(transactionDto.getTransaction().getCardNum());
        return transactionResponse;
    }


}
