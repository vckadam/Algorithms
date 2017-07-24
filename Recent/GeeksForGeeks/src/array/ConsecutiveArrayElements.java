package array;


public class ConsecutiveArrayElements {
	public boolean isConsecutive(Integer[] array) {
		int len;
		if(array != null && (len = array.length) > 0) {
			int min = Integer.MAX_VALUE;
			long sum = 0;
			for(Integer num : array) {
				if(num != null) {
					sum += num.intValue();
					min = Math.min(min, num.intValue());
				} 
				else return false;
			}
			return (double)len / 2 * (2 * (long)min + (len-1)) == sum;
		}
		return false;
	}
}
