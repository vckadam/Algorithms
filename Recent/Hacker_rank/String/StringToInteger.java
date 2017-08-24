/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.
*/

public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        int num = 0 , i = 0;
        while(str.charAt(i) == ' ') i++;
        int sign = (str.charAt(i) == '-')?-1:1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            if(num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && (str.charAt(i)-'0') > Integer.MAX_VALUE%10) 
                return (sign == 1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            num = 10* num + (str.charAt(i++)-'0');
        }
        return num*sign;
    }
}