/*

Castle on the Grid

You are given a grid with both sides equal to . Rows and columns are numbered from  to . There is a castle on the intersection of the th row and the th column.

Your task is to calculate the minimum number of steps it would take to move the castle from its initial position to the goal position ().

It is guaranteed that it is possible to reach the goal position from the initial position.

Note: You can move the castle from cell  to any  in a single step if there is a straight horizontal line or a straight vertical line between  and  that does not contain any forbidden cell. Here, "X" denotes a forbidden cell.

Input Format

The first line contains an integer , the size of the grid.

The following  lines contains a string of length  that consists of one of the following characters: "X" or ".". Here, "X" denotes a forbidden cell, and "." denotes an allowed cell.

The last line contains , , denoting the initial position of the castle, and , , denoting the goal position. Here,  and  are space separated.

Constraints

 
 

Output Format

Output a single line: The integer denoting the minimum number of steps required to move the castle to the goal position.

Sample Input

3
.X.
.X.
...
0 0 0 2
Sample Output

3
Explanation

Here is a path that one could follow in order to reach the destination in  steps:

.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /*
        .....
        .....
        ..M..
        .A...
        (3,1) (2,2)
        queue -> (3,1)  - 0
                 (3,0), (2,1), (1,1) (0,1) (3,2) (3,3) (3,4) - 1
                 (2,0), (1,0), (0,0), (1,2), (0,2), (2,2) - 2
        */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                grid[i][j] = str.charAt(j);
                //System.out.print(grid[i][j]+" ");
            }
            //System.out.println();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        //System.out.println("a "+a+" b "+b+" c "+c+" d "+d);
        Queue<int[]> queue = new LinkedList<int[]>();
        Set<String> set = new HashSet<String>();
        queue.offer(new int[]{a,b});
        set.add(String.valueOf(a)+"#"+String.valueOf(b));
        int level = 0;
        boolean isFound = false;
        while(!queue.isEmpty() && !isFound) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if(temp[0] == c && temp[1] == d) {
                    isFound = true;
                    break;
                } 
                for(int row = temp[0]-1; row >= 0 && grid[row][temp[1]] != 'X'; row--) {
                    if(!set.contains(row+"#"+temp[1])){
                        set.add(row+"#"+temp[1]);
                        queue.offer(new int[]{row,temp[1]});
                    }
                }
                for(int row = temp[0]+1; row < n && grid[row][temp[1]] != 'X'; row++) {
                    if(!set.contains(row+"#"+temp[1])){
                        set.add(row+"#"+temp[1]);
                        queue.offer(new int[]{row,temp[1]});
                    }
                }
                for(int col = temp[1]-1; col >= 0 && grid[temp[0]][col] != 'X'; col--) {
                    if(!set.contains(temp[0]+"#"+col)) {
                        set.add(temp[0]+"#"+col);
                        queue.offer(new int[]{temp[0],col});
                    }
                }
                for(int col = temp[1]+1; col < n && grid[temp[0]][col] != 'X'; col++) {
                    if(!set.contains(temp[0]+"#"+col)) {
                        set.add(temp[0]+"#"+col);
                        queue.offer(new int[]{temp[0],col});
                    }
                }
            }
            if(!isFound) level++;
        }
        System.out.println(level);
    }
}