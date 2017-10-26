package search;
/*
 * Given two sorted arrays of size m and n respectively, 
 * you are tasked with finding the element that would be at the k’th position of the final sorted array.
 */
public class KthElementInTwoSortedArray {
	public int getKthSmallest(int[] arr1, int[] arr2, int k) {
		if((arr1 == null && arr2 == null) || k < 0 || k > arr1.length+arr2.length)
			throw new IllegalArgumentException("Illegal Arguments");
		int st1 = 0, st2 = 0;
		while( k > 1 ) {
			int mid = (k - 1)/2 - 1;
			if(mid < 0) mid = 0;
			if(st1+mid >= arr1.length || st2+mid >= arr2.length)
				break;
			if(arr1[st1+mid] < arr2[st2+mid]) {
				st1 += mid + 1;
				k -= mid + 1;
			} else {
				st2 += mid + 1;
				k -= mid + 1;
			}	
		}
		if(st1 >= arr1.length) return arr2[st2+k-1];
		if(st2 >= arr2.length) return arr1[st1+k-1];
		return arr1[st1] < arr2[st2] ? arr1[st1] : arr2[st2];
	}
}
