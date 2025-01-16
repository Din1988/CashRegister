package com.company.squareCalculation;

import java.util.concurrent.RecursiveAction;

public class SquareFunctionInvokeAll extends RecursiveAction {
	final int min = 10;
	long[] data;
	int start, end;

	SquareFunctionInvokeAll(long[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if ((end - start) < min) {
			for (int i = start; i < end; i++) {
				data[i] = data[i] * data[i];
			}
		} else {
			int middle = (start + end) / 2;
			invokeAll(new SquareFunctionInvokeAll(data, start, middle),
					new SquareFunctionInvokeAll(data, middle, end));
		}
	}
}

