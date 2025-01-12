package com.company.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankLock {

	private final Lock lock = new ReentrantLock();
	private Long balance = 100L;

	public void getCash(long value, String name) {
		lock.lock();
		try {
			if (balance >= value) {
				balance -= value;
				System.out.println(name + " success " + value);
			} else {
				System.out.println(name + " error " + value);
			}
		} finally {
			lock.unlock();
		}
	}


	public static void main(String[] args) {
		BankLock bankLock = new BankLock();
		Thread person1 = new Thread(() -> bankLock.getCash(100, "Person 1"));
		Thread person2 = new Thread(() -> bankLock.getCash(80, "Person 2"));
		Thread person3 = new Thread(() -> bankLock.getCash(90, "Person 3"));

		person1.start();
		person2.start();
		person3.start();
	}


}
