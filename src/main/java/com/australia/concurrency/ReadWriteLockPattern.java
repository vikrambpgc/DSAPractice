package com.australia.concurrency;

public class ReadWriteLockPattern {
    private int readers = 0;
    private boolean writerLock = false;

    public synchronized void readLock() {
        while (writerLock) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Handle exception
            }
        }
        readers++;
    }

    public synchronized void readUnlock() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    public synchronized void writeLock() {
        while (readers > 0 || writerLock) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Handle exception
            }
        }
        writerLock = true;
    }

    public synchronized void writeUnlock() {
        writerLock = false;
        notifyAll();
    }
}
