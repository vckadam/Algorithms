package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortInAscDecOrder {
	
	/** Returns array with smallest, largest, 2nd smallest, 2nd largest ...*/
	public void sortArray(int[] array) {
		if(array == null)
			throw new IllegalArgumentException("Illegal Argument");
		if(array.length <= 1)
			return;
		Arrays.sort(array);
		Map<Integer,Integer> lastInd = new HashMap<Integer,Integer>();
		int left = 0, right = array.length-1, ind1 = 0, ind2 = 1;
		while(left <= right) {
			if(left <= right) 
				lastInd.put(array[left++], ind1);
			if(left <= right)
				lastInd.put(array[right--], ind2);
			ind1+=2;
			ind2+=2;
		}
		int i = 0;
		while(i < array.length) {
			int ind;
			if(i != (ind = lastInd.get(array[i])))
				swap(array,i,ind);
			else 
				i++;
		}
		return;
	}
	
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
