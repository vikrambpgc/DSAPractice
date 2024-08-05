package com.australia.concurrency;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int counter;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.counter = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (this.counter < 2 * n) {
            if (this.counter % 3 == 0) {
                printNumber.accept(counter);
                this.counter++;
                notifyAll();
            } else {
                wait();
            }

        }

    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (this.counter < 2 * n) {
            if (this.counter % 3 == 1) {
                printNumber.accept(counter);
                this.counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (this.counter < 2 * n) {
            if (this.counter % 3 == 2) {
                printNumber.accept(counter);
                this.counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}
