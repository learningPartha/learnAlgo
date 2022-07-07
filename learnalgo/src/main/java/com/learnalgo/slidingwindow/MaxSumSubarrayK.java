package com.learnalgo.slidingwindow;

import java.util.Arrays;

/*Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].*/

public class MaxSumSubarrayK {
	
	public static int findMaxSumSubarray(int k, int[] arr) {//(Complexity O(N) since looping over array on N elements only once)
		int maxSum =0, windowSum=0, windowStart=0;
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++) {//loop through array
			windowSum +=arr[windowEnd]; //keep adding element to sum
			// slide the window if we have hit required number of element in array 'k' - k is window size
			if(windowEnd>=k-1) {//crossed end of window
				maxSum = Math.max(maxSum, windowSum);//find max Sum
				windowSum -= arr[windowStart];//substract element going out of window after sliding
				windowStart++;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int maxSumValue1 = MaxSumSubarrayK.findMaxSumSubarray(3, new int[] {2,1,5,1,3,2});
		System.out.println("Max sum of subarray of 3 for example 1 "+maxSumValue1);
		int maxSumValue2 = MaxSumSubarrayK.findMaxSumSubarray(2, new int[] {2,3,4,1,5});
		System.out.println("Max sum of subarray of 2 for example 2 "+maxSumValue2);
	}

}
