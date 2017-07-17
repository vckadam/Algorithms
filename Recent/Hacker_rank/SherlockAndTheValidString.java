/* 
Sherlock and the Valid String

Sherlock considers a string, , to be valid if either of the following conditions are satisfied:

All characters in  have the same exact frequency (i.e., occur the same number of times). For example,  is valid, but  is not valid.
Deleting exactly  character from  will result in all its characters having the same frequency. For example,  and  are valid because all their letters will have the same frequency if we remove  occurrence of c, but  is not valid because we'd need to remove  characters.
Given , can you determine if it's valid or not? If it's valid, print YES on a new line; otherwise, print NO instead.

Input Format

A single string denoting .

Constraints

String  consists of lowercase letters only (i.e., [a-z]).
Output Format

Print YES if string  is valid; otherwise, print NO instead.

Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

We would need to remove two characters from  to make it valid, because a and b both have a frequency of  and c and d both have a frequency of . This means  is invalid because we'd need to remove more than  character to make all its letters have the same frequency, so we print NO as our answer.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isValid(String s){
        long[] count = new long[26];
        for(int i = 0; i < s.length(); i++) count[s.charAt(i)-'a']++;
        long num1 = 0, num2 = 0;
        long num1Count = 0, num2Count = 0;
        boolean flag = false;
        for(int i = 0; i < 26; i++) {
            if(count[i] == 0) continue;
            if(count[i] == num1) {
                num1Count++;
            } else if(count[i] == num2) {
                num2Count++;
            } else {
                if(num1 == 0) {
                    num1 = count[i];
                    num1Count++;
                } else if(num2 == 0) {
                    num2 = count[i];
                    num2Count++;
                }  else {
                    flag = true; break;
                }
            }
        }
        if(flag || (num1Count > 1 && num2Count > 1)) {// more than 2 freq or 2 freq with more than 1 count for each
            return "NO";
        } else if(num1 == 1 || num2 == 1) { // if input is "abbbb"
            return "YES";
        } else if(num2 != 0 && Math.abs(num1-num2) > 1) { // If difference between freq is > 1
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
