package stack;

public class DecodeSequence {
	/*
	 * Given a sequence consisting of  ‘I’  and  ‘D’  where ‘I’  denotes increasing sequence and 
	 * ‘D’  denotes the decreasing sequence. Decode the given sequence to construct minimum number without repeated digits.
	 * IIDDIDID –> 125437698
	 * IDIDII   –> 1325467
	 * DDDD     –> 54321
	 * IIII     –> 12345
	 * 
	 */
	public int getDecodeSequence(String str) {
		if(str == null || str.length() == 0 || str.length() > 8)
			throw new IllegalArgumentException("Illegal Argument");
		int left = 0, right = 0;
		int[] array = {1,2,3,4,5,6,7,8,9};
		for(; right < str.length(); right++) {
			if(str.charAt(right) == 'D')
				continue;
			if(left != right) {
				reverse(array,left,right);
				left = right;
			}
			left++;
		}
		if(left != right)
			reverse(array,left,right);
		return formNumber(array,0,right);
	}
	
	public int formNumber(int[] array, int start, int end) {
		int ret = 0;
		for(int i = start; i <= end; i++) {
			ret = 10 * ret + array[i];
		}
		return ret;
	}
	
	public void reverse(int[] array, int i, int j) {
		while(i < j) {
			int temp = array[i];
			array[i++] = array[j];
			array[j--] = temp;
		}
	}
}
