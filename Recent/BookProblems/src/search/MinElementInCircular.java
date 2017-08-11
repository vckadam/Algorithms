package search;

public class MinElementInCircular {
	public int getMinElement(int[] array) {
		/*
		 * [1,3] [3,1]
		 * [1 2 2 2 2] [2 1 2 2 2] [2 2 1 2 2] [2 2 2 1 2] [2 2 2 2 1]
		 * [1 2 3 4] 
		 * [1 2 3 4 5]
		 */
		if(array == null || array.length == 0) 
			throw new IllegalArgumentException("Illegal Argument");
		int left = 0, right = array.length-1;
		while(left < right) {
			int mid = (left + right) >> 1;
			if(array[left] < array[right]) 
				return array[left];
			else if(array[left] < array[mid]) {
				left = mid + 1;
			}
			else if(array[left] > array[mid])
				right = mid;
			else left++;
		}
		return array[left];
	}
}
