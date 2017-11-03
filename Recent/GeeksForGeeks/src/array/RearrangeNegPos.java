package array;

public class RearrangeNegPos {
	
	public void rearrange(int[] array) {
		if(array == null)
			throw new IllegalArgumentException("Illegal Argument");
		int left = 0;
		for(int i = 0; i < array.length; i++)
			if(array[i] < 0)
				swap(array, i, left++);
	}
	
	public void swap(int[] array, int i, int j) {
		if(i != j) {
			array[i] ^= array[j];
			array[j] ^= array[i];
			array[i] ^= array[j];
		}
	}
}
