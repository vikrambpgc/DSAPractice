package com.australia.LLD;

import java.time.Duration;
import java.time.Instant;

// https://github.com/natarajsbhargav/token-bucket/tree/master/src/main/java/com/bhargav
// https://www.youtube.com/watch?v=FU4WlwfS3G0
public class RateLimiter {
    private int capacity;
    private int tokens;
    private Duration rate;
    private Instant lastChecked;

    public RateLimiter(int capacity, Duration rate) {
        this.capacity = capacity;
        this.tokens = 0;
        this.rate = rate;
        this.lastChecked = Instant.now();
    }

    public void addToken() {
        Instant now = Instant.now();
        long elapsed = Duration.between(lastChecked, now).toMillis();

        // Calculate tokens to add
        int tokensToAdd = (int) (elapsed / rate.toMillis());

        // Update the bucket
        tokens = Math.min(capacity, tokens + tokensToAdd);
        lastChecked = now;
    }

    public boolean tryConsume() {
        addToken(); // Ensure the bucket is up to date

        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Bucket with capacity of 5 tokens and rate of 1 token/sec
        RateLimiter bucket = new RateLimiter(5, Duration.ofSeconds(1));

        // Simulate sending messages
        for (int i = 0; i < 10; i++) {
            if (bucket.tryConsume()) {
                System.out.println("Message sent");
            } else {
                System.out.println("Rate limit exceeded");
            }
        }
    }
}
