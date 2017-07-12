package AtMostKDistinctCharacter;

public class AtMostKDistinctCharacter {
	public int getLongestSubString(String s, int k) {
		if(s == null || k <= 0) return 0;
		if(s.length() <= k) return s.length();
		int left = 0, right = 0, count = 0, ret = 0;
		int[] strA = new int[255];
		while(right < s.length()) {
			if(strA[s.charAt(right++)]++ == 0) count++;
			if(count > k) {
				ret = Math.max(ret, right-left-1);
				while(left < right && count > k) {
					if(strA[s.charAt(left++)]-- == 1) count--;
				}
			}
		}
		ret = Math.max(ret, right-left);
		return ret;
	}
}
