package bitmanipulation;

public class ReverseBit {
	public int getReversedBitNumber(int n) {
		int ret = 0;
		for(int i = 0; i < 32; i++) {
			int temp = n & (1 << i);
			ret <<= 1;
			temp >>= i;
			ret |= temp;
		}
		return ret;
	}
}
