package array;

public class FindIndTo0Max1Seq {
	public int getIndex(int[] array) {
		if(array == null || array.length == 0) 
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
}
