/*
Maximum Element

You have an empty sequence, and you will be given  queries. Each query is one of these three types:

1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
Input Format

The first line of input contains an integer, . The next  lines each contain an above mentioned query. (It is guaranteed that each query is valid.)

Constraints 
 
 

Output Format

For each type  query, print the maximum element in the stack on a new line.

Sample Input

10
1 97
2
1 20
2
1 26
1 20
2
3
1 91
3
Sample Output

26
91

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queryCount = sc.nextInt();
        Stack<Long> eleStack = new Stack<Long>();
        Stack<Long> maxStack = new Stack<Long>();
        for(int k = 0; k < queryCount; k++) {
            int status = sc.nextInt();
            if(status == 1) {
                long num = sc.nextLong();
                if(maxStack.isEmpty() || num >= maxStack.peek()) maxStack.push(num);
                eleStack.push(num);
            } else if(status == 2) {
                if(eleStack.isEmpty()) throw new RuntimeException("Stack is Empty");
                long temp = eleStack.pop();
                if(temp == maxStack.peek()) maxStack.pop();
            } else {
                System.out.println(maxStack.peek());
            }
        }
        
    }
}