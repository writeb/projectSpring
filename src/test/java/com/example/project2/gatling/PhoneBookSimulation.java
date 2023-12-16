package com.example.project2.gatling;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import java.time.Duration;

import io.gatling.javaapi.core.OpenInjectionStep.RampRate.RampRateOpenInjectionStep;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class PhoneBookSimulation extends Simulation{
    private static final HttpProtocolBuilder HTTP_PROTOCOL_BUILDER = http.baseUrl("http://localhost:8000")
            .acceptHeader("application/json")
            .maxConnectionsPerHost(10)
            .userAgentHeader("Gatling/Performance Test");

    private static final ScenarioBuilder POST_SCENARIO_BUILDER = scenario("Load Test Add Phone")
            .exec(http("add-phone-request").post("/phone")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYXVhbkBnbWFpbC5jb20iLCJpYXQiOjE3MDI1NDUzODUsImV4cCI6MTcwMjU0NjgyNX0.4_iyBCPK5la3OLBPgM-DKPZww7xi7mR0uyIGw6zXf44")
                    .header("Content-Type", "application/json")
                    .body(StringBody("{\n" +
                            "    \"name\":\"Bhjhjhjaid\",\n" +
                            "    \"phone_number\":\"87477137802\",\n" +
                            "    \"email\":\"baido@gmail.com\",\n" +
                            "    \"b_day\":\"2003-04-24\",\n" +
                            "    \"organization\":\"KBTU\",\n" +
                            "    \"user_id\":2\n" +
                            "}"))
                    .check(status().is(200)));

    public PhoneBookSimulation() {
        setUp(POST_SCENARIO_BUILDER.injectOpen(postEndpointInjectionProfile())
                .protocols(HTTP_PROTOCOL_BUILDER)).assertions(global().responseTime()
                .max()
                .lte(10000), global().successfulRequests()
                .percent()
                .gt(90d));
    }

    private RampRateOpenInjectionStep postEndpointInjectionProfile() {
        int totalDesiredUserCount = 200;
        double userRampUpPerInterval = 50;
        double rampUpIntervalSeconds = 30;

        int totalRampUptimeSeconds = 120;
        int steadyStateDurationSeconds = 300;
        return rampUsersPerSec(userRampUpPerInterval / (rampUpIntervalSeconds / 60)).to(totalDesiredUserCount)
                .during(Duration.ofSeconds(totalRampUptimeSeconds + steadyStateDurationSeconds));
    }
}