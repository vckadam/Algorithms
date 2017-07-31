/*
650. 2 Keys Keyboard My SubmissionsBack to Contest
User Accepted: 858
User Tried: 1122
Total Accepted: 880
Total Submissions: 3140
Difficulty: Medium
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Note:
The n will be in the range [1, 1000].
*/

public class Solution {
    public int minSteps(int n) {
        /*
        0 - 0
        1 - A - 0
        2 - copy , paste - 2
        3 - copy , paste , paste - 3
        4 - copy, paste, paste, paste - 4
        5 - copy, paste, paste, paste, paste 
        A - AA - AAA - AAAA - AAAAA - AAAAAA
        7 - copy, P, 
        AAAAA - A - AAAAAA
        even - last eve + 2
        odd - previous + 1
        */
        if(n == 1) return 0;
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++) dp[i] = i;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; i*j <= n; j++)
                dp[i*j] = Math.min(dp[i*j],dp[i]+j);
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}