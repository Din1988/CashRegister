package com.company.two;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CashThreadFactory implements ThreadFactory {
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private String threadlNamePrefix = "";

	public CashThreadFactory(String threadlNamePrefix) {
		this.threadlNamePrefix = threadlNamePrefix;
	}

	public Thread newThread(Runnable runnable) {
		return new Thread(runnable, threadlNamePrefix + threadNumber.getAndIncrement());
	}
}
