package array;

public class FindIndTo0Max1Seq {
	public int getIndex(int[] array) {
		if(array == null) 
			throw new IllegalArgumentException("Illegal Argument");
		int left = 0, right = 0, count = 0;
		int ansLeft = -1, ansRight = -1;
		while(right < array.length) {
			if(array[right++]==0) count++;
			if(right-left > ansRight-ansLeft) {
				ansLeft = left; 
				ansRight = right;
			}
			if(count > 1) {
				while(left < right && count > 1) 
					if(array[left++] == 0)
						count--;
			}
		}
		if(ansLeft != -1 && ansRight != -1) {
			for(int i = ansLeft; i < ansRight; i++) 
				if(array[i] == 0) 
					return i;
		}
		return -1;
	}
	
	public int getIndex2(int[] array) {
		if(array == null)
			throw new IllegalArgumentException("Illegal Argument");
		int maxLen = 0, ind = 0, prevZero = -1, prevPrevZero = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i]== 0) {
				prevPrevZero = prevZero;
				prevZero = i;
			}
			if(i - prevPrevZero > maxLen) {
				ind = prevZero;
			}
		}
		return ind;
	}
}
