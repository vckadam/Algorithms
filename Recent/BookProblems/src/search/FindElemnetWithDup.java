package search;

public class FindElemnetWithDup {
	public int getFirstIndex(int[] array, int num) {
		/*
		 *  1 2 2 3 5 6 6 7 8 8 8 8
		 */
		
		if(array != null && array.length > 0) {
			int left = 0, right = array.length - 1, mid = 0;
			while(left <= right) {
				mid = left + (right - left) / 2;
				if(array[mid] == num) {
					while(mid > 0 && array[mid-1] == num) mid--;
					return mid;
				}
				else if(num < array[mid]) 
					right = mid - 1;
				else 
					left = mid + 1;
			}
		}
		throw new IllegalArgumentException("Invalid Input: "+array);
	}
}
