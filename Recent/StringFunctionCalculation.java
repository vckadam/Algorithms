/*
Jane loves string more than anything. She made a function related to the string some days ago and forgot about it. She is now confused about calculating the value of this function. She has a string with her, and value of string  over function  can be calculated as given below:

Jane wants to know the maximum value of  among all the substrings  of string . Can you help her?

Input Format 
A single line containing string  in small letter('a' - 'z').

Output Format 
An integer containing the value of output.

Constraints 

Sample Input #00

aaaaaa
Sample Output #00

12
Explanation #00

f('a') = 6
f('aa') = 10
f('aaa') = 12
f('aaaa') = 12
f('aaaaa') = 10
f('aaaaaa') = 6
Sample Input #01

abcabcddd
Sample Output #01

9
Explanation #01

f values of few of the substrings are shown below:

f("a") = 2
f("b") = 2
f("c") = 2
f("ab") = 4
f("bc") = 4
f("ddd") = 3
f("abc") = 6
f("abcabcddd") = 9
Among the function values 9 is the maximum one.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String,Integer> hm = new HashMap<>();
        helper(str,hm,0);
        System.out.println(max);
    }
    private static void helper(String str, Map<String,Integer> hm, int start) {
        if(start == str.length()) return;
        for(int i = start+1; i <= str.length(); i++) {
            String currStr = str.substring(start,i);
            int currOcc = getOccurance(str,hm,currStr);
            max = Math.max(max,currOcc * currStr.length());
        }
        helper(str,hm,start+1);
    }
    private static int getOccurance(String str, Map<String,Integer> hm, String currStr) {
        if(hm.containsKey(currStr)) return hm.get(currStr);
        int currOcc = 0;
        for(int i = 0; i <= str.length()-currStr.length(); i++) {
            if(str.substring(i,i+currStr.length()).equals(currStr)) currOcc++;
        }
        hm.put(currStr,currOcc);
        return currOcc;
    }
}