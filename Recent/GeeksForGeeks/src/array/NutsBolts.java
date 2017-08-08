package array;

public class NutsBolts {
	public void getArragedNuts(int[] bolts, int[] nuts){
		if(bolts == null || nuts == null || bolts.length != nuts.length) 
			throw new IllegalArgumentException("Illegal Arguments");
		helper(bolts, nuts, 0, bolts.length-1);
	}
	
	public void helper(int[] bolts, int[] nuts, int left, int right) {
		if(left > right) return;
		int pivot = partition(bolts, left, right, bolts[right]);
		partition(nuts, left, right, bolts[pivot]);
		helper(bolts,nuts,left,pivot-1);
		helper(bolts,nuts,pivot+1,right);
	}
	
	public int partition(int[] array, int left, int right, int piVal) {
		/* 
		 * 1 2 4 5 3
		 * p p p p
		 * */
		int ptr = left;
		boolean first = true; // To avoid duplicate
		for(int j = left; j < right; j++)  {
			if(array[j] < piVal) 
				swap(array,j,ptr++);
			else if(first && array[j] == piVal)  {
				swap(array,j--,right);
				first = false;
			}
		}
		swap(array,ptr,right);
		return ptr;
	}
	
	public void swap(int[] array, int i, int j) {
		if(i == j) return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
