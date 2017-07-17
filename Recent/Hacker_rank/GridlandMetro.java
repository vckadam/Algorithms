/* 
Gridland Metro

The city of Gridland is represented as an  matrix where the rows are numbered from  to and the columns are numbered from  to .

Gridland has a network of train tracks that always run in straight horizontal lines along a row. In other words, the start and end points of a train track are  and , where  represents the row number,  represents the starting column, and  represents the ending column of the train track.

The mayor of Gridland is surveying the city to determine the number of locations where lampposts can be placed. A lamppost can be placed in any cell that is not occupied by a train track.

Given a map of Gridland and its  train tracks, find and print the number of cells where the mayor can place lampposts.

Note: A train track may (or may not) overlap other train tracks within the same row.

Input Format

The first line contains three space-separated integers describing the respective values of  (the number of rows),  (the number of columns), and  (the number of train tracks). 
Each line  of the  subsequent lines contains three space-separated integers describing the respective values of , , and  that define a train track.

Constraints

Output Format

Print a single integer denoting the number of cells where the mayor can install lampposts.

Sample Input

4 4 3
2 2 3
3 1 4
4 4 4
Sample Output

9
Explanation

maze.png

In the diagram above, the yellow cells denote the first train track, green denotes the second, and blue denotes the third. Lampposts can be placed in any of the nine red cells, so we print  as our answer.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        int k = sc.nextInt();
        long[][] array = new long[k][3];
        long ret = 0;
        for(int row = 0; row < k; row++) {
            for(int col = 0; col < 3; col++) array[row][col] = sc.nextLong();
        }
        Map<Long,List<long[]>> hm  = new HashMap<Long,List<long[]>>();
        for(long[] row : array) {
            if(!hm.containsKey(row[0])) hm.put(row[0],new ArrayList<long[]>());
            hm.get(row[0]).add(row);
        }
        Comparator<long[]> comp = new Comparator<long[]>() {
            public int compare(long[] A1, long[] A2) {
                if(A1[1] <= A2[1]) return -1;
                else return 1;
            }
        };
        for(Long key : hm.keySet()) {
            List<long[]> list = hm.get(key);
            Collections.sort(list, comp);
            ret += getFilledSpace(list);
        }
        System.out.println(m*n - ret);
    }
    public static long getFilledSpace(List<long[]> list) {
        long[] start = list.get(0);
        long ret = 0;
        for(int i = 1; i < list.size(); i++) {
            if(start[2] + 1 >= list.get(i)[1]) start[2] = Math.max(start[2], list.get(i)[2]);
            else {
                ret += (start[2]-start[1]+1);
                start = list.get(i);
            }
        }
        ret += (start[2]-start[1]+1);
        return ret;
    }
}