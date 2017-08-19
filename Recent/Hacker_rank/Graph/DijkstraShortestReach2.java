/*
Dijkstra: Shortest Reach 2

Given a graph consisting  nodes (labelled  to ) where a specific given node  represents the starting position  and an edge between two nodes is of a given length, which may or may not be equal to other lengths in the graph.

It is required to calculate the shortest distance from the start position (Node ) to all of the other nodes in the graph.

Note: If a node is unreachable , the distance is assumed as .

Input Format

The first line contains , denoting the number of test cases. 
First line of each test case has two integers , denoting the number of nodes in the graph and , denoting the number of edges in the graph.

The next  lines each consist of three space-separated integers   , where  and  denote the two nodes between which the undirected edge exists,  denotes the length of edge between these corresponding nodes.

The last line has an integer , denoting the starting position.

Constraints 
 
 
 
 

If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

Output Format

For each of the  test cases, print a single line consisting  space separated integers denoting the shortest distance of  nodes other than  from starting position  in increasing order of their labels.

For unreachable nodes, print .

Sample Input

1
4 4
1 2 24
1 4 20
3 1 3
4 3 12
1
Sample Output

24 3 15
Explanation

The graph given in the test case is shown as :

image

The straight line is a weighted edge, denoting length of edge between the corresponding nodes.
The nodes S,B,C and D denote the obvious node 1,2,3 and 4 in the test case.
The shortest paths followed for the three nodes B,C and D are as follows :

S->B - Shortest Path Value : 

S->C - Shortest Path Value : 

S->C->D - Shortest Path Value : 
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        //Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int t = in.nextInt();
        int t = Integer.parseInt(br.readLine());
        for(int a0 = 0; a0 < t; a0++){
            String[] strA = br.readLine().split(" ");
            //int n = in.nextInt();
            //int m = in.nextInt();
            int n = Integer.parseInt(strA[0]);
            int m = Integer.parseInt(strA[1]);
            Map<Integer,List<Integer>> adjMap = new HashMap<Integer,List<Integer>>();
            int[][] weight = new int[n+1][n+1];
            int[] distance = new int[n+1];
            Arrays.fill(distance,-1);
            for(int a1 = 0; a1 < m; a1++){
                String[] edgA = br.readLine().split(" ");
                int x = Integer.parseInt(edgA[0]);
                int y = Integer.parseInt(edgA[1]);
                int r = Integer.parseInt(edgA[2]);
                //int x = in.nextInt();
                //int y = in.nextInt();
                //int r = in.nextInt();
                if(weight[x][y] == 0) {
                    putInMap(adjMap,x,y);
                    putInMap(adjMap,y,x);
                }
                if(weight[y][x] == 0 || r < weight[x][y]) {
                    weight[y][x] = r;
                    weight[x][y] = r;
                }
            }
            int s = Integer.parseInt(br.readLine());
            //int s = in.nextInt();
            distance[s] = 0;
            
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
            Map<Integer,int[]> hm = new HashMap<Integer,int[]>();
            Set<Integer> visited = new HashSet<Integer>();
            int[] firstEntry;
            pq.add((firstEntry = new int[]{s,0}));
            hm.put(s,firstEntry);
            while(!pq.isEmpty()) {
                int[] temp = pq.poll();
                visited.add(temp[0]);
                List<Integer> neighbours = adjMap.get(temp[0]);
                if(neighbours != null) {
                    for(Integer neighbour : neighbours) {
                        if(!visited.contains(neighbour)) {
                            int d = distance[temp[0]] + weight[temp[0]][neighbour];
                            if(distance[neighbour] == -1) {
                                int[] pqEntry;
                                pq.add((pqEntry = new int[]{neighbour,d}));
                                distance[neighbour] = d;
                                hm.put(neighbour,pqEntry);
                            }
                            else if(d < distance[neighbour]) {
                                int[] curr = hm.get(neighbour);
                                pq.remove(curr);
                                distance[neighbour] = d;
                                curr[1] = d;
                                pq.add(curr);
                            }
                        }
                    }
                }
            }
            for(int i = 1; i <= n; i++) {
                if(i == s) continue;
                System.out.print(distance[i]+" ");
            }
            System.out.println();
        }
    }
    public static void putInMap(Map<Integer,List<Integer>> map, int x, int y) {
        if(!map.containsKey(x))
            map.put(x,new ArrayList<Integer>(Arrays.asList(y)));
        else 
            map.get(x).add(y);
    }
}
