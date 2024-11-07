package com.company.one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CashRegister {

	private final ExecutorService executor = Executors.newSingleThreadExecutor();

	public void buy(int clientNumber) {
		executor.submit(() -> {
			this.start(clientNumber);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.finish(clientNumber);
		});
	}

	public void stop() {
		executor.shutdownNow();
	}

	private void start(int clientNumber) {
		System.out.printf("Customer №%d service has begun", clientNumber);
		System.out.println();
	}

	private void finish(int clientNumber) {
		System.out.printf("Customer №%d service has ended", clientNumber);
		System.out.println();
	}


}
