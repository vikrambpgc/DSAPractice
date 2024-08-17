package com.australia.LLD.routingservice;

import java.util.HashMap;
import java.util.Map;

public class RoutingService {
    private final Map<String, RouteHandler> routes = new HashMap<>();

    public void addRoute(String path, RouteHandler handler) {
        routes.put(path, handler);
    }

    public void route(String path, RequestContext request) {
        RouteHandler handler = routes.get(path);
        if (handler != null) {
            handler.handle(request);
        } else {
            // Handle unknown route
        }
    }


}
