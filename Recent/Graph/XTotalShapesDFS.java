/*
X Total Shapes
Given N * M string array of O's and X's
Return the number of 'X' total shapes. 'X' shape consists of one or more adjacent X's (diagonals not included).

Example (1):

OOOXOOO
OXXXXXO
OXOOOXO

answer is 1 , shapes are  :
(i)     X
    X X X X
    X     X
 

Example (2):

XXX
OOO
XXX

answer is 2, shapes are
(i)  XXX

(ii) XXX

Input:
The first line of input takes the number of test cases, T.
Then T test cases follow. Each of the T test cases takes 2 input lines.
The first line of each test case have two integers N and M.The second line of N space separated strings follow which indicate the elements in the array.

Output:

Print number of shapes.

Constraints:

1<=T<=100

1<=N,M<=50

Example:

Input:
2
4 7
OOOOXXO OXOXOOX XXXXOXO OXXXOOO
10 3
XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO

Output:
4
6
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int k = 0; k < testCase; k++) {
		    int row = sc.nextInt();
		    int col = sc.nextInt();
		    int ret = 0;
		    char[][] grid = new char[row][col];
		    boolean[][] visited = new boolean[row][col];
		    for(int i = 0; i < row; i++) {
		        String str = sc.next();
		        for(int j = 0; j < str.length(); j++) {
		            grid[i][j] = str.charAt(j);
		        }
		    }
		    for(int i = 0; i < row; i++) {
		        for(int j = 0; j < col; j++) {
		            if(!visited[i][j] && grid[i][j] == 'X') {
		                dfs(grid,visited,i,j);
		                ret++;
		            }
		        }
		    }
		    System.out.println(ret);
		}
	}
	public static void dfs(char[][] grid, boolean[][] visited, int i, int j){
	    if(i < 0 || j < 0 || i == grid.length || j == grid[0].length|| visited[i][j]) return;
	    visited[i][j] = true;
	    if(i > 0 && !visited[i-1][j] && grid[i-1][j] == 'X') 
	        dfs(grid, visited, i-1, j);
	    if(i < grid.length-1 && !visited[i+1][j] && grid[i+1][j] == 'X')
	        dfs(grid, visited, i+1, j);
	    if(j > 0 && !visited[i][j-1] && grid[i][j-1] == 'X') 
	        dfs(grid, visited, i, j-1);
	    if(j < grid[0].length-1 && !visited[i][j+1] && grid[i][j+1] == 'X')
	        dfs(grid, visited, i, j+1);
	}
}
