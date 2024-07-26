package com.australia.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueImpl<T> {
    private final int maxSize;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final T[] queue;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public BlockingQueueImpl(int maxSize) {
        this.maxSize = maxSize;
        this.queue = (T[]) new Object[maxSize];
    }

    public void put(T item) throws InterruptedException {
        lock.lock();
        try {
            while (size == maxSize) {
                notFull.await();
            }
            queue[tail] = item;
            tail = (tail + 1) % maxSize;
            size++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            T item = queue[head];
            head = (head + 1) % maxSize;
            size--;
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }

    //testing
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueImpl<Integer> queue = new BlockingQueueImpl<>(5);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Integer item = queue.take();
                    System.out.println("Consumed: " + item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
