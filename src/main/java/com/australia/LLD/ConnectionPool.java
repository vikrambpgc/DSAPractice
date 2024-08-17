package com.australia.LLD;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private BlockingQueue<Connection> pool;

    public ConnectionPool(int initialSize) {
        pool = new ArrayBlockingQueue<>(initialSize);
        initialize(initialSize);
    }

    public Connection getConnection() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            // Handle exception
        }
    }

    public void returnConnection(Connection conn) {
        pool.add(conn);
    }

    private void initialize(int initialSize) {
        for (int i = 0; i < initialSize; i++) {
            pool.add(createNewConnection());
        }
    }

    private Connection createNewConnection() {
        // Create a new database connection
    }

    public void shutdown() {
        pool.forEach(Connection::close);
    }
}
