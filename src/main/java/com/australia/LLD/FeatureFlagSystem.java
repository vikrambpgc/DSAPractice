package com.australia.LLD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeatureFlagSystem {
}

// FeatureFlag.java
public class FeatureFlag {
    private String name;
    private boolean enabled;
    private List<Rule> rules;

    public FeatureFlag(String name, boolean enabled, List<Rule> rules) {
        this.name = name;
        this.enabled = enabled;
        this.rules = rules;
    }

    public boolean evaluate(Context context) {
        for (Rule rule : rules) {
            if (!rule.evaluate(context)) {
                return false;
            }
        }
        return enabled;
    }
}

// Rule.java
abstract class Rule {
    public abstract boolean evaluate(Context context);
}

// UserAttributeRule.java
class UserAttributeRule extends Rule {
    private String attribute;
    private String value;

    public UserAttributeRule(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public boolean evaluate(Context context) {
        return context.getUser().getAttribute(attribute).equals(value);
    }
}

// EnvironmentVariableRule.java
class EnvironmentVariableRule extends Rule {
    private String variable;
    private String value;

    public EnvironmentVariableRule(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }

    public boolean evaluate(Context context) {
        return context.getEnvironment().getVariable(variable).equals(value);
    }
}

// FeatureFlagService.java
class FeatureFlagService {
    private Map<String, FeatureFlag> featureFlags;

    public FeatureFlagService() {
        featureFlags = new HashMap<>();
    }

    public void createFeatureFlag(String name, boolean enabled, List<Rule> rules) {
        featureFlags.put(name, new FeatureFlag(name, enabled, rules));
    }

    public boolean evaluateFeatureFlag(String name, Context context) {
        FeatureFlag featureFlag = featureFlags.get(name);
        if (featureFlag == null) {
            return false;
        }
        return featureFlag.evaluate(context);
    }
}

// Context.java
class Context {
    private User user;
    private Environment environment;

    public Context(User user, Environment environment) {
        this.user = user;
        this.environment = environment;
    }

    public User getUser() {
        return user;
    }

    public Environment getEnvironment() {
        return environment;
    }
}

// User.java
class User {
    private Map<String, String> attributes;

    public User(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String name) {
        return attributes.get(name);
    }
}

// Environment.java
class Environment {
    private Map<String, String> variables;

    public Environment(Map<String, String> variables) {
        this.variables = variables;
    }

    public String getVariable(String name) {
        return variables.get(name);
    }
}
