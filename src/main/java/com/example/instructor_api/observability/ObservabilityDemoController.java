package com.example.instructor_api.observability;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/observe")
public class ObservabilityDemoController {

    private static final Logger logger =
            LoggerFactory.getLogger(ObservabilityDemoController.class);

    @GetMapping("/ping")
    public Map<String, Object> ping() {
        logger.info("Ping endpoint called");

        return Map.of(
                "message", "Backend is running",
                "status", "OK"
        );
    }

    @GetMapping("/slow")
    public Map<String, Object> slowEndpoint() throws InterruptedException {
        logger.info("Slow endpoint called");

        Thread.sleep(1500);

        logger.info("Slow endpoint completed");

        return Map.of(
                "message", "Slow endpoint completed",
                "delay", "1500ms"
        );
    }

    @GetMapping("/fail")
    public Map<String, Object> failEndpoint() {
        logger.warn("Fail endpoint called");

        throw new RuntimeException("Demo failure for observability practice");
    }
}