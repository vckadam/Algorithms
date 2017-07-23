/*
647. Palindromic Substrings My SubmissionsBack to Contest
User Accepted: 966
User Tried: 1075
Total Accepted: 981
Total Submissions: 1758
Difficulty: Medium
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
*/

public class Solution {
    public int countSubstrings(String s) {
        int ret = 0;
        for(int i = 0; i < s.length(); i++) {
            ret += getPalindromeNumber(s, i, i);
            //System.out.println("i "+i+" "+ret);
            if(i < s.length()-1) ret += getPalindromeNumber(s, i, i+1);
            //System.out.println("i "+i+" "+ret);
        }
        return ret;
    }
    
    public int getPalindromeNumber(String s, int i, int j) {
        int ret = 0;
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i--) == s.charAt(j++)) ret++;
            else return ret;
        }
        return ret;
    }
}