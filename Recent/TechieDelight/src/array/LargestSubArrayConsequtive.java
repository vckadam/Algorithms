package array;
/*
 * Given an array of integers, find largest sub-array formed by 
 * consecutive integers.
 * {2,0,2,1,4,3,1,0} -> {1, 5}
 * TimeComplexity : - O(n3)
 */
public class LargestSubArrayConsequtive {
	public int[] getSubArray(int[] array) {
		if(array == null || array.length == 0)
			throw new IllegalArgumentException("Illigal Argument");
		int maxLen = 1,retI = 0, retJ = 0;
		for(int i = 0; i + 1 < array.length; i++) {
			int min = array[i], max = array[i];
			for(int j = i+1; j < array.length; j++) {
				min = Math.min(min, array[j]);
				max = Math.max(max, array[j]);
				if(isConsequtive(array,i,j,min,max)) {
					if(j-i+1 > maxLen) {
						maxLen = j - i + 1;
						retI = i;
						retJ = j;
					}
				} 
			}
		}
		return new int[]{retI,retJ};
	}
	
	public boolean isConsequtive(int[] array, int i, int j, int min, int max) {
		if(j-i != max-min)
			return false;
		boolean[] status = new boolean[j-i+1];
		for(int k = i; k <= j; k++) {
			if(status[array[k]-min])
				return false;
			status[array[k]-min] = true;
		}
		return true;
	}
}
