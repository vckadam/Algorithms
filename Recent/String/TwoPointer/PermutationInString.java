/*
567. Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

*/

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0) return true;
        if(s2.length() == 0 || s2.length() < s1.length()) return false;
        int[] array = new int[26];
        for(int i = 0; i < s1.length(); i++) array[s1.charAt(i)-'a']++;
        int count = s1.length(),left = 0, right = 0;
        while(right < s2.length()) {
            if(array[s2.charAt(right++)-'a']-- > 0) count--;
            if(count == 0 || right-left >= s1.length()) {
                if(count == 0) return true;
                while(left < right && right - left >= s1.length()) 
                    if(array[s2.charAt(left++)-'a']++ >= 0) 
                        count++;
            }
        }
        return false;
    }
}