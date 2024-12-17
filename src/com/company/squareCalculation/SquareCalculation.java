package com.company.squareCalculation;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class SquareCalculation {


	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		long[] nums = LongStream.rangeClosed(0, 1000).toArray();
		SquareFunction function = new SquareFunction(nums, 0, nums.length);
		System.out.println(Arrays.toString(nums));
		forkJoinPool.invoke(function);
		System.out.println(Arrays.toString(nums));
	}
}
