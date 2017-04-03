/*
547. Friend Circles
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

*/

public class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int ret = M.length;
        int[] A = new int[M.length];
        for(int i = 0; i < A.length; i++) A[i] = i;
        for(int i = 0; i < M.length; i++) {
            for(int j = i+1; j < M.length; j++) {
                if(M[i][j] != 1) continue;
                int parent1 = find(A,i);
                int parent2 = find(A,j);
                if(parent1 == parent2) continue;
                A[parent2] = parent1;
                ret--;
            }
        }
        return ret;
    }
    public int find(int[] A, int ind) {
        if(ind == A[ind]) return ind;
        A[ind] = find(A,A[ind]);
        return A[ind];
    }
}