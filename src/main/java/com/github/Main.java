package com.github;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 4, 3, 5, 2};
		int output = findDuplicate(input);
		System.out.println(output);

		input = new int[] {1, 2, 4, 4, 5, 4, 6, 3};
		output = findDuplicate(input);
		System.out.println(output);
	}

	private static int findDuplicate(int[] numbers) {
		if (numbers != null && numbers.length > 0) {
			int largestNum = 0;
			int largestValue = 0;
			int[] histogram = new int[1024];

			for (int i = 0; i < numbers.length; i++) {
				if (histogram[numbers[i]] != 0) {
					int value = histogram[numbers[i]] + 1;
					histogram[numbers[i]] = value;
					if (largestValue < value) {
						largestValue = value;
						largestNum = numbers[i];
					}
				} else {
					histogram[numbers[i]] = 1;
				}
			}
			return largestNum;
		} else {
			throw new RuntimeException();
		}
	}
	
	private static int findDuplicateUsingHashMap(int[] numbers) {
		if (numbers != null && numbers.length > 0) {
			int largestNum = 0;
			int largestValue = 0;
			Map<Integer, Integer> histogram = new HashMap<>();

			for (int i = 0; i < numbers.length; i++) {
				if (histogram.containsKey(numbers[i])) {
					int value = histogram.get(numbers[i]) + 1;
					histogram.put(numbers[i], value);
					if (largestValue < value) {
						largestValue = value;
						largestNum = numbers[i];
					}
				} else {
					histogram.put(numbers[i], 1);
				}
			}
			return largestNum;
		} else {
			throw new RuntimeException();
		}
	}
	
}
