package WindowAverage;

public class WindowAverage {
	public Integer[] getWindowSum(Integer[] array, int k) {
		if(array == null) return null;
		if(array.length == 0 || k <= 0) return new Integer[0];
		Integer[] ret = null;
		if(k <= array.length) {
			ret = new Integer[array.length-k+1];
		}
		long sum = 0;
		for(int i = 0; i < array.length; i++) {
			if(i >= k && array[i-k] != null) sum -= array[i-k];
			if(array[i] != null) sum += array[i];
			if(i >= k-1) ret[i-k+1] = (int) ((sum <= (long)Integer.MAX_VALUE )? sum : Integer.MAX_VALUE); 
		}
		if(k > array.length) return new Integer[]{(int) ((sum <= (long)Integer.MAX_VALUE )? sum : Integer.MAX_VALUE)};
		return ret;
	}
}
