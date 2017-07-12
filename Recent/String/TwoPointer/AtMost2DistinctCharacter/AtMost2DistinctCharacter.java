package AtMost2DistinctCharacter;

public class AtMost2DistinctCharacter {
	public int getLongestSubString(String s) {
		if(s == null) return 0;
		if(s.length() <= 2) return s.length();
		int left = 0, right = 0, count = 0, ret = 0;
		int[] strA = new int[255];
		while(right < s.length()) {
			if(strA[s.charAt(right++)]++ == 0) count++;
			if(count > 2) {
				ret = Math.max(ret, right-left-1);
				while(left < right && count > 2) {
					if(strA[s.charAt(left++)]-- == 1) count--;
				}
			}
		}
		ret = Math.max(ret, right-left);
		return ret;
	}
}
