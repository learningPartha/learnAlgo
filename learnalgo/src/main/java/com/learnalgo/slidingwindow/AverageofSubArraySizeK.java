package com.learnalgo.slidingwindow;

import java.util.Arrays;

/*Let’s understand this problem with a real input:

Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:

For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
…*/


public class AverageofSubArraySizeK {//Sliding Window (Complexity O(N) since looping over array on N elements only once)
	
	public static double[] findAverages(int k , int[] arr) {
		double[] result = new double[arr.length-k+1];
		double windowSum = 0;
		int windowStart = 0;
		for(int windowEnd=0; windowEnd<arr.length;windowEnd++) {// check till end of array
			windowSum += arr[windowEnd];// keep adding array element
			// slide the window if we have hit required number of element in array 'k' - k is window size
			if(windowEnd>=k-1) {//crossed end of window
				result[windowStart]=windowSum/k;//calculate average
				windowSum -=arr[windowStart];//substract element going out of window after sliding
				windowStart++;//slide window ahead
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		double[] result = AverageofSubArraySizeK.findAverages(5, new int[] {1,3,2,6,-1,4,1,8,2});
		System.out.println("Average of Subarray of size k is "+Arrays.toString(result));
	}

}
