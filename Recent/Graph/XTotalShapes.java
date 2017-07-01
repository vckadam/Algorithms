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
		int k = sc.nextInt();
		
		for(int testCase = 0; testCase < k; testCase++) {
		int row = sc.nextInt();
		int col = sc.nextInt();
		char[][] grid = new char[row][col];
		for(int i = 0; i < row; i++) {
		    String curr = sc.next();
		    for(int j = 0; j < col; j++) {
		        grid[i][j] = curr.charAt(j);
		    }
		}
		int ret = 0;
		boolean[][] visited = new boolean[row][col];
		for(int i =0 ; i < grid.length; i++) {
		    for(int j = 0; j < grid[0].length; j++) {
		        if(!visited[i][j] && grid[i][j] == 'X') {
		            bfs(grid, i, j, visited);
		            ret++;
		        }
		    }
		}
		System.out.println(ret);
		}
	}
	public static void bfs(char[][] grid, int i, int j, boolean[][] visited) {
	    Queue<int[]> queue = new LinkedList<int[]>();
	    queue.offer(new int[]{i,j});
	    while(!queue.isEmpty()) {
	        int[] temp = queue.poll();
	        visited[temp[0]][temp[1]] = true;
	        int row = temp[0], col = temp[1];
	        if(row > 0 && !visited[row-1][col] && grid[row-1][col] == 'X')
	            queue.offer(new int[]{row-1,col});
	        if(row < grid.length-1 && !visited[row+1][col] && grid[row+1][col] == 'X')
	            queue.offer(new int[]{row+1,col});
	        if(col > 0 && !visited[row][col-1] && grid[row][col-1] == 'X') 
	            queue.offer(new int[]{row,col-1});
	        if(col < grid[0].length-1 && !visited[row][col+1] && grid[row][col+1] == 'X')
	            queue.offer(new int[]{row,col+1});
	    }
	}
}