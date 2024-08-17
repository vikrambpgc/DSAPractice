package com.australia.LLD.routingservice;

import java.util.Collections;

public class RouterExample {
    public static void main(String[] args) {
        RoutingService router = new RoutingService();

        router.addRoute("/users", new RouteHandler() {
            @Override
            public void handle(RequestContext request) {
                // Handle GET /users
            }
        });

        router.addRoute("/users/:id", new RouteHandler() {
            @Override
            public void handle(RequestContext request) {
                // Handle GET /users/:id
                String id = request.getParams().get("id");
                // ...
            }
        });

        RequestContext request = new RequestContext("GET", "/users", Collections.emptyMap());
        router.route(request.getPath(), request);
    }
}
