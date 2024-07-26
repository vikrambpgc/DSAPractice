package com.australia.concurrency;

class Printer {
    private static int num = 1;

    public synchronized void printEven() {
        while (num <= 10) {
            if (num % 2 == 0) {
                System.out.println("Even: " + num);
                num++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized void printOdd() {
        while (num <= 10) {
            if (num % 2 != 0) {
                System.out.println("Odd: " + num);
                num++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class PrintSequence {
    public static void main(String[] args) {
        Printer printer = new Printer();

        //Thread evenThread = new Thread(() -> printer.printEven());
        //Thread oddThread = new Thread(() -> printer.printOdd());

        Thread evenThread = new Thread(printer::printEven);
        Thread oddThread = new Thread(printer::printOdd);

        evenThread.start();
        oddThread.start();
    }
}
