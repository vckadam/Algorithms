/* 
Once in a tram

Your submission will run against only preliminary test cases. Full test cases will run at the end of the day.
One day, Jack was going home by tram. When he got his ticket, he noticed that number on the ticket was not lucky. A lucky ticket is a six-digit number on the ticket in which sum of the first three digits is equal to the sum of the last three digits.

For example, number 165912 is lucky because sum of , and .

Since the number on the ticket wasn't lucky, Jack needs your help to find the next lucky ticket number.

For example, if Jack's ticket number is 165901, then the next lucky ticket number is 165903.

Given Jack's current ticket number, find and print the next lucky ticket number.

Input Format

The first line contains an integer, , denoting the  number on the ticket.

Constraints

Output Format

For the given input find and print the next lucky ticket number.

Sample Input 0

555555
Sample Output 0

555564
Explanation 0

After  the first lucky number is , where the sum of first three digits  is equal to the sum of last three digits .

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String onceInATram(int x) {
        String str = getNext(x);
        if(str.length() != 0) return str;
        while(str.length() == 0) {
            x = x + 1;
            str = getNext(x);
        }
        return str;
    }
    public static String getNext(int x) {
        String str = String.valueOf(x);
        int sum = Integer.valueOf(str.substring(0,1))+
            Integer.valueOf(str.substring(1,2))+
            Integer.valueOf(str.substring(2,3));
        int d1 = Integer.valueOf(str.substring(5));
        int d2 = Integer.valueOf(str.substring(4,5));
        int d3 = Integer.valueOf(str.substring(3,4));
        int currSum = 0;
        for(int i = d3; i <= 9; i++) {
            int startJ = (i == d3) ? d2 : 0;
            if(i > sum) break;
            for(int j = startJ; j <= 9; j++) {
                currSum = i + j;
                if(currSum <= sum) {
                    int digit = sum - currSum;
                    if(digit > 9) continue;
                    if(i == d3 && j == d2 && digit <= d1) continue;
                    return str.substring(0,3)+""+i+""+j+""+digit;
                }
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String result = onceInATram(x);
        System.out.println(result);
    }
}
