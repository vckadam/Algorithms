/* 
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int[] strA = new int[255];
        int left = 0, right = 0, count = 0, ret = 0;
        while(right < s.length()) {
            if(strA[s.charAt(right++)]++ > 0) count++;
            if(count > 0) {
                ret = Math.max(ret, right-left-1);
                while(left < right && count > 0) {
                    if(strA[s.charAt(left++)]-- > 1) count--;
                }
            }
        }
        ret = Math.max(ret, right-left);
        return ret;
    }
}