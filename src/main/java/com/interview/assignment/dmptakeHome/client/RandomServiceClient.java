package com.interview.assignment.dmptakeHome.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


/**
 * This class is used to call the external service to fetch the transaction count in last 7 days
 */
@Service
@Slf4j
public class RandomServiceClient {
    WebClient client;

    @Autowired
    public RandomServiceClient(@Value("${rest.randomservice.baseUrl}") String baseUrl) {
        this.client = WebClient.builder().baseUrl(baseUrl).build();
    }

    public String[] getTransactionByDay() {
        String response = this.client.get().uri("/integers/?num=7&min=0&max=12&col=1&base=10&format=plain&rnd=new").retrieve().bodyToMono(String.class).block();
        assert response != null;
        return response.split("\\r?\\n");

    }

    /**
     * It is used to check the health of the external service
     * @return health status of the external service
     */
    public Mono<Health> getHealth() {
        return this.client.get().uri(uriBuilder -> uriBuilder
                        .path("/integers/")
                        .queryParam("num", 7)
                        .queryParam("min", 0)
                        .queryParam("max", 12)
                        .queryParam("col", 1)
                        .queryParam("base", 10)
                        .queryParam("format", "plain")
                        .queryParam("rnd", "new")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .map(s -> new Health.Builder().up().build())
                .onErrorResume(ex -> Mono.just(new Health.Builder().down(ex).build()))
                .log();
    }
}