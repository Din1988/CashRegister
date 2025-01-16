package com.company.squareCalculation;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class SquareCalculation {


	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		long[] nums = LongStream.rangeClosed(0, 1000).toArray();
		SquareFunctionInvokeAll function = new SquareFunctionInvokeAll(nums, 0, nums.length);
		System.out.println(Arrays.toString(nums));
		forkJoinPool.invoke(function);
		System.out.println(Arrays.toString(nums));

		long[] nums2 = LongStream.rangeClosed(0, 1000).toArray();
		SquareFunctionForkJoin functionForkJoin = new SquareFunctionForkJoin(nums2, 0, nums2.length);
		System.out.println(Arrays.toString(nums2));
		forkJoinPool.invoke(functionForkJoin);
		System.out.println(Arrays.toString(nums2));
	}
}
