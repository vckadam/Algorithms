package array;

import java.util.HashMap;
import java.util.Map;

public class AllElementsInRange {
	/** checks array contains all the positive elements in range [a,b].*/
	public boolean areInRangePositive(Integer[] array, Integer a, Integer b) {
		 /* 
		  * 
		  * array = {1,2,3,4,3,7} a = 1, b = 4 
		  * int[] status - len = 4 - 1 + 1
		  * status = { 1, 1, 1, 1 }
		  * int count = 4
		  * count == len 
		  * -2147483648  2147483647
		  * 
		  */
		 if(array != null && a != null && b != null) {
			 int min = Math.min(a, b);
			 int max = Math.max(a, b);
			 int range = max - min + 1, count = 0;
			 int[] status = new int[range];
			 for(Integer num : array) {
				 if(num != null) {
					 if(num >= min && num <= max) {
						 if(status[num-min]++ == 0) count++;
					 }
				 }
			 }
			 return (count == range);
		 }
		 else return false;
	}
	
	public boolean areInRangePosNeg(Integer[] array, Integer a, Integer b) {
		 if(array != null && a != null && b != null) {
			 int min = Math.min(a, b);
			 int max = Math.max(a, b);
			 long range = max - min + 1, count = 0;
			 Map<Integer,Integer> statusMap = new HashMap<>();
			 for(Integer num : array) {
				 if(num != null) {
					 if(num >= min && num <= max) {
						 if(!statusMap.containsKey(num)) {
							 count++;
							 statusMap.put(num, 1);
						 } else {
							 statusMap.put(num, statusMap.get(num)+1);
						 }
					 }
				 }
			 }
			 return (count == range);
		 }
		 else return false;
	}
}
