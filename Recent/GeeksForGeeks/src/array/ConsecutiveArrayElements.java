package array;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArrayElements {
	public boolean isConsecutive(Integer[] array) {
		if(array != null && array.length > 1) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			Set<Integer> set = new HashSet<Integer>();
			long sum = 0;
			for(Integer num : array) {
				if(num != null) {
					if(!set.contains(num)) {
						sum += num.intValue();
						min = Math.min(min, num.intValue());
						max = Math.max(max, num.intValue());
						set.add(num);
					}
					else return false;
				} 
				else return false;
			}
			return (double)(max - min + 1) / 2 * ((long)min + max) == sum;
		}
		return array == null ? false : array.length == 1;
	}
}
