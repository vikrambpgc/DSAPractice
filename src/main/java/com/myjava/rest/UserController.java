package com.myjava.rest;

import org.springframework.web.bind.annotation.*;

/**
 * In this example:
 * @RestController indicates that this class is a controller where every method returns a domain object instead of a view.
 * @RequestMapping("/api") specifies the base URL for all methods in this controller.
 * @GetMapping handles HTTP GET requests.
 * @PostMapping handles HTTP POST requests.
 * @PutMapping handles HTTP PUT requests.
 * @DeleteMapping handles HTTP DELETE requests.
 * @PathVariable injects the value of a URI template variable into a method parameter.
 * @RequestBody injects the body of a HTTP request into a method parameter.
 *
 * This example covers the following REST methods:
 * GET /hello (returns a simple message)
 * GET /users (returns a list of users)
 * GET /users/{id} (returns a user by ID)
 * POST /users (creates a new user)
 * PUT /users/{id} (updates an existing user)
 * DELETE /users/{id} (deletes a user by ID)
 *
 *
 * In this updated example:
 * @RequestParam injects the value of a query parameter into a method parameter.
 * required = false indicates that the query parameter is optional.
 * The /users endpoint now accepts an optional name query parameter.
 * The /search endpoint accepts optional name and age query parameters.
 * 
 * You can test the query parameters by calling the endpoints with query strings, such as:
 * GET /api/users?name=John
 * GET /api/search?name=John&age=30
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/users")
    public List<String> getUsers(@RequestParam(required = false) String name) {
        if (name != null) {
            return Arrays.asList(name);
        } else {
            return Arrays.asList("John", "Jane", "Bob");
        }
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") int id) {
        return "User " + id;
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        return "User created: " + user.getName();
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return "User updated: " + user.getName();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return "User deleted: " + id;
    }

    @GetMapping("/search")
    public List<String> searchUsers(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        if (name != null && age != null) {
            return Arrays.asList(name + " " + age);
        } else if (name != null) {
            return Arrays.asList(name);
        } else {
            return Arrays.asList("John", "Jane", "Bob");
        }
    }
}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
