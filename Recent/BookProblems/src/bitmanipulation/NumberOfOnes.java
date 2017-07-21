package bitmanipulation;

public class NumberOfOnes {

	public int getNumberOfOnes(int n) {
		int[] table = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4};
		int ret = 0;
		/*
		 *   0000 
		 *   0001
		 *   0010
		 *   0011
		 *   0100
		 *   0101
		 *   0110
		 *   0111
		 *   1000
		 *   1001
		 *   1010
		 *   1011
		 *   1100
		 *   1101
		 *   1110
		 *   1111
		 */
		for(; n > 0 ; n >>= 4) {
			ret += table[(n & 0xF)];
		}
		return ret;
	}
}
