package array;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArrayElements {
	public boolean isConsecutive(Integer[] array) {
		int len;
		if(array != null && (len = array.length) > 0) {
			int min = Integer.MAX_VALUE;
			Set<Integer> set = new HashSet<Integer>();
			long sum = 0;
			for(Integer num : array) {
				if(num != null) {
					if(!set.contains(num)) {
						sum += num.intValue();
						min = Math.min(min, num.intValue());
						set.add(num);
					}
					else return false;
				} 
				else return false;
			}
			return (double)len / 2 * (2 * (long)min + (len-1)) == sum;
		}
		return false;
	}
}
