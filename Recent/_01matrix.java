/*
542. 01 Matrix
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
*/

public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j) != 0) matrix.get(i).set(j,Integer.MAX_VALUE);
            }
        }
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j) != 0) {
                    continue;
                }
                dfs(matrix, i+1, j, 1);
                dfs(matrix, i-1, j, 1);
                dfs(matrix, i, j-1, 1);
                dfs(matrix, i, j+1, 1);
            }
        }
        return matrix;
    }
    public void dfs(List<List<Integer>> matrix, int i, int j, int count) {
        if(i < 0 || j < 0 || i == matrix.size() || j == matrix.get(i).size() || matrix.get(i).get(j) == -1 || matrix.get(i).get(j) == 0) return;
        int temp = matrix.get(i).get(j);
        matrix.get(i).set(j,-1);
        dfs(matrix,i+1,j,count+1);
        dfs(matrix,i-1,j,count+1);
        dfs(matrix,i,j-1,count+1);
        dfs(matrix,i,j+1,count+1);
        matrix.get(i).set(j,Math.min(temp,count));
        return;
    }
}

/////////////// Another vesion

public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j) != 0) matrix.get(i).set(j,Integer.MAX_VALUE);
            }
        }
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j) != 0) {
                    continue;
                }
                dfs(matrix, i+1, j, 1);
                dfs(matrix, i-1, j, 1);
                dfs(matrix, i, j-1, 1);
                dfs(matrix, i, j+1, 1);
            }
        }
        return matrix;
    }
    public void dfs(List<List<Integer>> matrix, int i, int j, int count) {
        if(i < 0 || j < 0 || i == matrix.size() || j == matrix.get(i).size() || matrix.get(i).get(j) == -1 || matrix.get(i).get(j) == 0) return;
        int temp = matrix.get(i).get(j);
        matrix.get(i).set(j,-1);
        if(i < matrix.size()-1 && matrix.get(i+1).get(j) > count+1) dfs(matrix,i+1,j,count+1);
        if(j > 0 && matrix.get(i).get(j-1) > count+1) dfs(matrix,i,j-1,count+1);
        if(i > 0 && matrix.get(i-1).get(j) > count+1) dfs(matrix,i-1,j,count+1);
        if(j < matrix.get(i).size()-1 && matrix.get(i).get(j+1) > count+1) dfs(matrix,i,j+1,count+1);
        matrix.get(i).set(j,Math.min(temp,count));
        return;
    }
}