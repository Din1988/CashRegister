package com.company.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Future {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		CompletableFuture<String> resultOne = CompletableFuture.supplyAsync(
				Future::firstApiCall
		);

		CompletableFuture<String> resultTwo = CompletableFuture.supplyAsync(
				Future::secondApiCall
		).exceptionally(throwable -> {
			System.out.println("Error");
			return "Error";
		});
		System.out.println("Result 1: " + resultOne.get() + " 2: " + resultTwo.get());
	}

	private static String firstApiCall() {
		int i = new Random().nextInt(5);
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "First result";
	}

	private static String secondApiCall() {
		int i = new Random().nextInt(5);
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (new Random().nextBoolean()) {
			throw new RuntimeException("Error");
		}
		return "Second result";
	}


}
