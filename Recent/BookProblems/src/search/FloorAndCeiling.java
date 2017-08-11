package search;

public class FloorAndCeiling {
	public int getFloor(int[] array, int num) {
		/*  L R
		 *  2 4  - in between
		 *  1 2 - both less
		 *  4 5 - both grater
		 *  3
		 *  mid = left + (left + right + 1)/2;
		 */
		if(array == null || array.length == 0)
			throw new IllegalArgumentException("Illegal Argument");
		if(array[0] > num)
			return -1;
		int left = 0, right = array.length - 1; 
		while(left < right) {
			int mid = (right + left + 1) >> 1;
			if(num == array[mid]) return num;
			else if(num < array[mid]) right = mid - 1;
		    else left = mid;
		}
		return array[left];
	}
	
	public int getCeiling(int[] array, int num) {
		if(array == null || array.length == 0)
			throw new IllegalArgumentException("Illegal Argument");
		if(array[array.length-1] < num)
			return -1;
		int left = 0, right = array.length-1;
		while(left < right) {
			int mid = (left + right) >> 1;
			if(num == array[mid]) return num;
			else if(num > array[mid]) left = mid + 1;
			else right = mid;
		}
		return array[left];
	}
}
