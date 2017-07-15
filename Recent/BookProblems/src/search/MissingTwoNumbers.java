package search;

public class MissingTwoNumbers {
	public int[] getMissingNumbers(int[] array, int n) {
		/* 
		 * 1, 3, 5
		 * 1, 2, 3, 4, 5
		 * xor - 2 & 4
		 * 2 - 10
		 * 4 - 100
		 * p = xor of 2 & 4 - 110
		 * ~p = 001 
		 * ~p + 1 - 010
		 * q = p & (~p + 1) = 010
		 * 1 - 01 
		 * 1 & q = 0 , m ^= 1; two times
		 * 2 & q != 0, n ^= 2;
		 * 3 & q != 0, n ^= 3; two times
		 * 4 & q == 0, m ^= 4;
		 * 5 & q == 0, m ^= 5; two times
		 * n = 2; m = 4;
		 * 
		 */
		if(n <= 1 || array == null) return new int[0];
		int xor = 0;
		for(int i = 0; i < n; i++) {
			if(i < array.length) xor ^= array[i];
			xor ^= (i+1);
		}
		xor = xor&(~xor + 1);
		int[] ret = new int[2];
		for(int i = 0; i < n; i++) {
			if(i < array.length) {
				if((xor & array[i]) == 0) ret[0] ^= array[i];
				else ret[1] ^= array[i];
			}
		    if((xor & (i+1)) == 0) ret[0] ^= (i+1);
		    else ret[1] ^= (i+1);
		}
		return ret;
	}
}
