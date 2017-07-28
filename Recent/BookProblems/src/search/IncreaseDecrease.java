package search;

public class IncreaseDecrease {
	public int getIndexChangeOrder(int[] array) {
		/* 5 6 5 4 3 2 1 0 -1
		 * 4 5 4
		 * 1 2 3 4 5 6
		 * 
		 * */
		if(array != null && array.length > 2) {
			int left = 0, right = array.length-1, mid = 0;
			while(left < right-1) {
				mid = left + (right - left)/2;
				if(array[mid-1] < array[mid] && array[mid] > array[mid+1]) {
					return mid;
				} else if(array[mid-1] < array[mid] && array[mid] < array[mid+1]) {
					left = mid;
				} else 
					right = mid;
			}
		}
		throw new IllegalArgumentException("Invalid input");
	}
}
