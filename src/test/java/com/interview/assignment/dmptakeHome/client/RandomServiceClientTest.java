package com.interview.assignment.dmptakeHome.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Assert;
import org.junit.Test;

public class RandomServiceClientTest {
    RandomServiceClient randomServiceClient;
    public static MockWebServer mockBackEnd;

    @Test
    public void getNumberOfTransactionsByDay() throws Exception {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
        String baseUrl = String.format("http://localhost:%s",
                mockBackEnd.getPort());
        randomServiceClient = new RandomServiceClient(baseUrl);

        //Integer transactionByDay = 12;
        String transactionsByDay = "11\n" +
                "6\n" +
                "7\n" +
                "2\n" +
                "5\n" +
                "12\n" +
                "8\n";
        mockBackEnd.enqueue(new MockResponse()
                .setBody(transactionsByDay)
                .addHeader("Content-Type", "text/plain"));

        Assert.assertArrayEquals(transactionsByDay.split("\\r?\\n"),randomServiceClient.getTransactionByDay());
        mockBackEnd.shutdown();
    }


}
