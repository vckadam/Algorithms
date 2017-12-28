package string;

public class KthCharSubStringOcc {
	// returns kth character from occurance of substring 
	// ab2cd2 -> original string -> ababcdcd -> 4th character is b
	public char getkthCharacter(String str, int k) {
		if(k <= 0 || str == null || str.length() == 0)
			return '\0';
		int left, right;
		left = right = 0;
		while(right < str.length()) {
			while(right < str.length() && str.charAt(right) >= 'a' && str.charAt(right) <= 'z')
				right++;
			int numLen = 0;
			while(right < str.length() && str.charAt(right) >= '0' && str.charAt(right) <= '9') {
				numLen++; right++;
			}
			String currStr = str.substring(left, right-numLen);
			int occ = numLen == 0 ? 1 : Integer.parseInt(str.substring(right-numLen,right));
			if(k <= currStr.length() * occ) 
				return currStr.charAt((k-1) % currStr.length());
			k -= currStr.length() * occ;
			left = right;
		}
		return '\0';
	}
}
