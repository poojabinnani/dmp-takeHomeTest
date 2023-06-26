package com.interview.assignment.dmptakeHome.controller;

import com.interview.assignment.dmptakeHome.DmpTakeHomeApplication;
import com.interview.assignment.dmptakeHome.client.RandomServiceClient;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DmpTakeHomeApplication.class)
@AutoConfigureMockMvc
public class DmpTakeHomeApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RandomServiceClient randomServiceClient;

    @Test
    public void validateTransactionTest() throws Exception {
        Mockito.when(randomServiceClient.getTransactionByDay()).thenReturn(new String[]{"5", "5", "5", "6", "6", "6", "5"});
        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeTransaction").content("{\"transaction\": {\"cardNum\": 5206840000000001,\"amount\": 3.99}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(true)));
    }

    @Test
    public void validateTransactionTestWithHighAmount() throws Exception {
        Mockito.when(randomServiceClient.getTransactionByDay()).thenReturn(new String[]{"1", "10", "15", "20", "25", "30", "35"});
        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeTransaction").content("{\"transaction\": {\"cardNum\": 5206840000000001,\"amount\": 3.99}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(false)));
    }

    @Test
    public void validateTransactionTestWithAmountBreached() throws Exception {
        Mockito.when(randomServiceClient.getTransactionByDay()).thenReturn(new String[]{"5", "4", "3", "6", "5", "6", "7"});
        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeTransaction").content("{\"transaction\": {\"cardNum\": 5206840000000001,\"amount\": 51000}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(false)));
    }

}
