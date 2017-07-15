package search;
/*
 * Find the number with max occurrence 
 * where number in range of 0 - n-1
 * without extra space
 */
public class FindElementMaxOccur {
	public int getMaxOccur(int[] array) {
		int ret = 0, occu = 0;
		for(int i = 0; i < array.length; i++) {
			int ind = array[i] % array.length;
			array[ind] += array.length;
			if(array[ind]/array.length > occu){
				occu = array[ind]/array.length;
				ret = ind;
			}
		}
		return ret;
	}
}
