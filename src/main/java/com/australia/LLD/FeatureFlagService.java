package com.australia.LLD;

import java.util.HashMap;
import java.util.Map;

// FeatureFlagConfiguration.java
class FeatureFlagConfiguration {
    private Map<String, Boolean> flags;

    public FeatureFlagConfiguration(Map<String, Boolean> flags) {
        this.flags = flags;
    }

    public boolean isEnabled(String flagName) {
        return flags.getOrDefault(flagName, false);
    }
}

// FeatureFlagService.java
public class FeatureFlagService {
    private FeatureFlagConfiguration config;

    public FeatureFlagService(FeatureFlagConfiguration config) {
        this.config = config;
    }

    public boolean isEnabled(String flagName) {
        return config.isEnabled(flagName);
    }
}

// FeatureFlagClient.java
class FeatureFlagClient {
    private FeatureFlagService featureFlagService;

    public FeatureFlagClient(FeatureFlagService featureFlagService) {
        this.featureFlagService = featureFlagService;
    }

    public void doSomething() {
        if (featureFlagService.isEnabled("new-feature")) {
            // New feature logic
        } else {
            // Old feature logic
        }
    }
}

// Main.java
class Main {
    public static void main(String[] args) {
        Map<String, Boolean> flags = new HashMap<>();
        flags.put("new-feature", true);

        FeatureFlagConfiguration config = new FeatureFlagConfiguration(flags);
        FeatureFlagService service = new FeatureFlagService(config);
        FeatureFlagClient client = new FeatureFlagClient(service);

        client.doSomething();
    }
}
