package bitmanipulation;

public class SwapOddEvenPosition {
	public int changePosition(int n) {
		int odd = 0, even = 0;
		odd = (n & 0x55);
		even = (n & 0xAA);
		odd <<= 1;
		even >>= 1;
		return (odd | even);
	}
}
