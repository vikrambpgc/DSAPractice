package com.australia.concurrency;

import java.util.concurrent.Semaphore;
public class PrintSequenceSemaphore {
    private int n;
    private final Semaphore fooSemaphore = new Semaphore(1);
    private final Semaphore barSemaphore = new Semaphore(0);

    public PrintSequenceSemaphore(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            System.out.println("foo");
            barSemaphore.release();
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            System.out.println("bar");
            fooSemaphore.release();
        }
    }
}
