package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	
	/** returns sorted array as per non-increasing order of weights (A[i] % K)
	 *  and increasing order of value if weights are same.
	 */
	public int[] sortByWeight(int[] array, int K) {
		if(array == null || K <= 0) 
			throw new IllegalArgumentException("Illegal Arguments");
		if(array.length == 0)   //empty array
			return new int[0];
		int[] sortedArray = new int[array.length];
		List[] buckets = new ArrayList[K];
		for(int ele : array) {
			if(buckets[ele%K] == null) 
				buckets[ele%K] = new ArrayList<Integer>();
			buckets[ele%K].add(ele);
		}
		int ind = 0;
		for(int i = K-1; i >= 0; i--) {
			if(buckets[i] != null) {
				Collections.sort(buckets[i]);    // sorts values in increasing order in a bucket
				for(int ele : (List<Integer>)buckets[i]) 
					sortedArray[ind++] = ele;
			}
		}
		return sortedArray;
	}
	
	
}
