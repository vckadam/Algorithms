/* 
28. Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

public class KMP {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() == 0 || needle.length() > haystack.length()) return -1;
        int[] pattern = getPattern(needle);
        int i = 0, j = 0;
        while(i < haystack.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if(j == needle.length()) {
                    return (i - needle.length());
                }
            }
            else {
                if(j == 0) i++;
                else j = pattern[j-1];
            }
        }
        return -1;
    }
    public int[] getPattern(String needle) {
        int[] ret = new int[needle.length()];
        int j = 0, i = 1;
        while(i < needle.length()) {
            if(needle.charAt(i) == needle.charAt(j)) {
                ret[i] = j + 1;
                i++; j++;
            } else {
                if(j == 0) i++;
                else j = ret[j-1];
            }
        }
        return ret;
    }
}