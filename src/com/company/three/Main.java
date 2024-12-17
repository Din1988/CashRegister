package com.company.three;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CashRegister cashRegister = new CashRegister();
		System.out.println("Start two POS");
		int count = 1;
		while (true) {
			String line = scanner.nextLine();
			if ("q".equals(line)) {
				cashRegister.stop();
				return;
			}
			System.out.printf("Customer №%d added in queue", count);
			System.out.println();
			cashRegister.buy(count++);
		}
	}
}
