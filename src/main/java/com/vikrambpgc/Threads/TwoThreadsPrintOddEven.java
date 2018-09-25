package com.vikrambpgc.Threads;

public class TwoThreadsPrintOddEven {

	public static void main(String[] args) {
		PrinterJob p1 = new PrinterJob(1, 10);
        new Thread() {
        	@Override
			public void run() {
				//p1.printEvenNumbers();
			}
		}.start();
		
        new Thread() {
        	@Override
			public void run() {
				//p1.printOddNumbers();
			}
		}.start();
	}
}

class PrinterJob {
	private int maxNumber;
	private int currentNumber;
	private boolean evenPrinted;
	
    PrinterJob(int startNumber, int maxNumber) {
		this.maxNumber = maxNumber;
		this.currentNumber = startNumber;
		
		if (currentNumber % 2 == 0) evenPrinted = true;
		else evenPrinted = false;
	}
	
	public synchronized void printEvenNumbers() {
		while(currentNumber < maxNumber) {
			while (evenPrinted == true) {
				try {
					wait();
				} catch (InterruptedException e) {
					
				}
			}
			
			if (currentNumber < maxNumber) {
				System.out.println(Thread.currentThread().getName() + ": " + ++currentNumber + "\n");
				evenPrinted = true;
				notifyAll();
			}
		}
	}
	
	public synchronized void printOddNumbers() {
		while(currentNumber < maxNumber) {
			while (evenPrinted == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					
				}
			}
			
			if (currentNumber < maxNumber) {
				System.out.println(Thread.currentThread().getName() + ": " + ++currentNumber + "\n");
				evenPrinted = false;
				notifyAll();
			}
		}
	}
}


