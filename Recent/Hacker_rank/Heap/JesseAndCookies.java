/*
Jesse and Cookies

Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value . To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:

sweetness  Least sweet cookie   2nd least sweet cookie).

He repeats this procedure until all the cookies in his collection have a sweetness . 
You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness . Print  if this isn't possible.

Input Format

The first line consists of integers , the number of cookies and , the minimum required sweetness, separated by a space. 
The next line contains  integers describing the array  where  is the sweetness of the  cookie in Jesse's collection.

Constraints

 
 

Output Format

Output the number of operations that are needed to increase the cookie's sweetness . 
Output  if this isn't possible.

Sample Input

6 7
1 2 3 9 10 12
Sample Output

2
Explanation

Combine the first two cookies to create a cookie with sweetness  =  
After this operation, the cookies are . 
Then, combine the cookies with sweetness  and sweetness , to create a cookie with resulting sweetness  =  
Now, the cookies are . 
All the cookies have a sweetness . 

Thus,  operations are required to increase the sweetness.
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b)->a-b);
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            minHeap.add(num);
        }
        while(!minHeap.isEmpty() && minHeap.peek() < k && minHeap.size() >= 2) {
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();
            minHeap.add(num1 + 2 * num2);
            result++;
        }
        result = (!minHeap.isEmpty() && minHeap.peek() < k) ? -1 : result;
        System.out.println(result);
    }
}