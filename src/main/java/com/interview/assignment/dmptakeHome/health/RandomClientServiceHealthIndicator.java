package com.interview.assignment.dmptakeHome.health;

import com.interview.assignment.dmptakeHome.client.RandomServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


/**
 * This class is used to check the health of the external service.
 */
@Component
public class RandomClientServiceHealthIndicator implements ReactiveHealthIndicator {

    @Autowired
    RandomServiceClient randomServiceClient;

    @Override
    public Mono<Health> health() {
        return checkDownstreamServiceHealth().onErrorResume(
                ex -> Mono.just(new Health.Builder().down(ex).build())
        );
    }

    private Mono<Health> checkDownstreamServiceHealth() {
        return randomServiceClient.getHealth();
    }
}
