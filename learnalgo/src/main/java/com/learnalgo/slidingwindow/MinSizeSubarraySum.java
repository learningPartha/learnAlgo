package com.learnalgo.slidingwindow;


/*Problem Statement #
Given an array of positive numbers and a positive number �S�, find the length of the smallest contiguous subarray whose sum is greater than or equal to �S�. Return 0, if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8 
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
Try it yourself #*/

public class MinSizeSubarraySum {//Complexity O(N)
	
	public static int findMinSubArray(int S, int[] arr) {
		int windowSum=0, windowStart=0, minLength = Integer.MAX_VALUE;
		for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
			windowSum += arr[windowEnd];// add next element
			//shrink window smaller until windowSum is less than S
			while(windowSum>=S) {//if summation becomes greater than or equal to S
				minLength = Math.min(minLength, windowEnd-windowStart+1);
				windowSum -= arr[windowStart];//substract element going out of window
				windowStart++;//slide window ahead
			}
		}
		return minLength==Integer.MAX_VALUE?0:minLength;
	}

	public static void main(String[] args) {
		int result = MinSizeSubarraySum.findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2});
		System.out.println("Smallest subarray length "+result);
		result = MinSizeSubarraySum.findMinSubArray(7, new int[] {2, 1, 5, 2, 8});
		System.out.println("Smallest subarray length "+result);
		result = MinSizeSubarraySum.findMinSubArray(8, new int[] {3, 4, 1, 1, 6});	
		System.out.println("Smallest subarray length "+result);
	}

}
