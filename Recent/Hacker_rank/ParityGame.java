/* 
Parity Game

Mancunian is playing the famous Parity Game. In this game, the player is given an array comprising of  positive integers. The goal is to remove some (possibly empty) subsequence of these integers so that the sum of the resulting array is even. The player is NOT allowed to remove all the numbers (i.e. the resulting array should be nonempty).

There can be multiple possible subsequences that can be removed to achieve this. Print the size of the smallest such subsequence. If there is no such subsequence, print .

Input Format

The first line of input contains the size of the array, . 
The second line contains  space-separated integers, the  of which contains .

Constraints

Output Format

Print a single integer which is the answer to the given problem.

Sample Input 0

5
1 2 3 4 5
Sample Output 0

1
Explanation 0

The array is .

Some of the possible subsequences you can remove are , , , , ,  and among others. For example, if we remove the subsequence  from , we get which has an even sum.

The smallest size among these is , hence we print .

Sample Input 1

4
1 2 3 4
Sample Output 1

0
Explanation 1

The player doesn't need to remove any integer.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int smallestSizeSubsequence(int n, int[] A) {
        if(n == 1 && A[0] % 2 != 0) return -1;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += A[i];
        if(sum % 2 == 0) return 0;
        else return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int result = smallestSizeSubsequence(n, A);
        System.out.println(result);
    }
}
