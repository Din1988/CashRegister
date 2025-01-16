package com.company.bank;

import java.util.concurrent.atomic.AtomicLong;

public class BankAtomic {

	private final AtomicLong balance = new AtomicLong(100);

	public void getCash(long value, String name) {
		long currentBalance = balance.get();
		if (currentBalance > value && balance.compareAndSet(currentBalance, currentBalance - value)) {
			System.out.println(name + " success " + value + ". Balance " + balance.get());
		} else {
			System.out.println(name + " error " + value + ". Balance " + balance.get());
		}
	}

	public static void main(String[] args) {
		BankAtomic bankAtomic = new BankAtomic();
		Thread person1 = new Thread(() -> bankAtomic.getCash(50, "Person 1"));
		Thread person2 = new Thread(() -> bankAtomic.getCash(60, "Person 2"));
		Thread person3 = new Thread(() -> bankAtomic.getCash(70, "Person 3"));

		person1.start();
		person2.start();
		person3.start();
	}


}
