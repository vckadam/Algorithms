/*541. Reverse String II

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
*/

public class Solution {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() == 0) return "";
        if(k == 0) return s;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i+=(2*k)) {
            if(sb.length() - i < k) {
                reverse(sb,i,sb.length()-1);
                continue;
            }
            reverse(sb,i,i+k-1);
        }
        return sb.toString();
    }
    public void reverse(StringBuilder sb, int start, int end) {
        while(start < end) swap(sb,start++,end--);
    }
    public void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}