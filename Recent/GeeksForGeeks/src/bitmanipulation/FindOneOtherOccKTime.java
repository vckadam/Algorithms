package bitmanipulation;

public class FindOneOtherOccKTime {
	public int getNumber(int[] array, int k) {
		if(array == null || array.length == 0 || k < 0 || k >= array.length)
			throw new IllegalArgumentException("Illegal Argument");
		if(k == 0)
			return array[0];
		int[] count = new int[32];
		for(int i = 0; i < 32; i++) {
			for(int j = 0; j < array.length; j++) {
				count[(array[j]>>i)&1]++;
			}
		}
		for(int i = 0; i < 32; i++)
			count[i] %= k;
		return convertBToD(count);
	}
	
	public int convertBToD(int[] array) {
		if(array == null || array.length == 0)
			return 0;
		int ret = 0;
		for(int i = 31; i >= 0; i--) {
			ret |= array[i] << i;
		}
		return ret;
	}
}
