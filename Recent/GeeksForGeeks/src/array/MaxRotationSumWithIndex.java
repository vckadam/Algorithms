package array;
/*
 * Given an array arr[] of n integers, find the maximum that maximizes sum of value of i*arr[i] where i varies from 0 to n-1.

Examples:

Input : arr[] = {8, 3, 1, 2}
Output : 29
Explanation : Let us see all rotations
{8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11
{3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29
{1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27
{2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*1 = 17

Input : arr[] = {3, 2, 1}
Output : 8
 */
public class MaxRotationSumWithIndex {
	public int getMaxSum(int[] array) {
		if(array == null || array.length <= 1)
			return 0;
		int arrSum = 0, currSum = 0, maxSum;
		for(int i = 0; i < array.length; i++) {
			arrSum += array[i];
			currSum += i * array[i];
		}
		maxSum = currSum;
		for(int i = 1; i < array.length; i++) {
			int nextSum = currSum - (arrSum - array[i-1]) + (array.length-1)*array[i-1];
			currSum = nextSum;
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}
}
