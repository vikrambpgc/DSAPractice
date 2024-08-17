package com.australia.LLD.routingservice;

import java.util.Map;
import java.util.Objects;

public class RequestContext {
    private final String method;
    private final String path;
    private final Map<String, String> params;

    public RequestContext(String method, String path, Map<String, String> params) {
        this.method = method;
        this.path = path;
        this.params = params;
    }

    // Getters and setters
    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestContext)) return false;
        RequestContext that = (RequestContext) o;
        return Objects.equals(getMethod(), that.getMethod()) && Objects.equals(getPath(), that.getPath()) && Objects.equals(getParams(), that.getParams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMethod(), getPath(), getParams());
    }
}
