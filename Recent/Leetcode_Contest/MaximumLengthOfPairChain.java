/*
646. Maximum Length of Pair Chain My SubmissionsBack to Contest
User Accepted: 908
User Tried: 1146
Total Accepted: 927
Total Submissions: 2408
Difficulty: Medium
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].

*/

public class Solution {
    public int findLongestChain(int[][] pairs) {
        
        /* 
         [1,2] [3, 8] [4,5] [6,7]
        */
        PriorityQueue<int[]> ret = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if(a1[0] != a2[0]) return a1[0] - a2[0];
                else return a1[1] - a2[1];
            }
        });
        for(int[] pair : pairs) {
            ret.add(pair);
        }
        Stack<int[]> stack = new Stack<int[]>();
        while(!ret.isEmpty()) {
            int[] temp = ret.poll();
            if(stack.isEmpty()) stack.push(temp);
            else {
                while(!stack.isEmpty() && stack.peek()[1] > temp[1]) stack.pop();
                if(!stack.isEmpty() && temp[0] <= stack.peek()[1]) continue;
                stack.push(temp);
            }
        }
        //for(int[] array : stack) System.out.println(Arrays.toString(array));
        return stack.size();
    }
}