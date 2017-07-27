/*
Kruskal (MST): Really Special Subtree

Given an undirected weighted connected graph, it is required to find the Really Special SubTree in it. The Really Special SubTree is defined as a subgraph consisting of all the nodes in the graph and

There is only one exclusive path from a node to every other node.
The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
While creating the Really Special SubTree, start by picking the edge with smallest weight. If there are edges of equal weight available at an instant, then the edge to be chosen first among them is the one with minimum value of sum of the following expression :
u + wt + v , where u and v are the node numbers of the corresponding edge and wt is the weight.
Even then if there is a collision, choose any one of them.
While doing the above, ensure that no cycle is formed while picking up edges.
Finally, you need to print the overall weight of the Tree so formed using above rules.

Input Format

First line has two integers , denoting the number of nodes in the graph and , denoting the number of edges in the graph.

The next  lines each consist of three space separated integers   , where  and  denote the two nodes between which the undirected edge exists,  denotes the weight of edge between the corresponding nodes.

Constraints

*Note: * If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

Output Format

Print a single integer denoting the total weight (sum of weights of all edges in the MST) of the Really Special SubTree.

Sample Input 0

4 6
1 2 5
1 3 3
4 1 6
2 4 7
3 2 4
3 4 5
Sample Output 0

12
Explanation 0

The graph given in the test case is shown as :

Graph

The nodes A,B,C and D denote the obvious 1,2,3 and 4 node numbers.

The starting node is A or 1 (in the given test case)

Applying the Kruskal's algorithm, all the edges are sorted in ascending order of weight.

After sorting, the edge choices are available as :

A->C (WT. 3) , B->C (WT. 4) , A->B (WT. 5) , C->D (WT. 5) , A->D (WT. 6) and B->D (WT. 7)

Picking these edges and finalizing only if it doesnt create a cycle :

A->C : B->C

Now, when A->B edge is picked , it can be easily seen that they both belong to same set (form a cycle) and hence this edge is ignored.

The process continues and the following edge sequence is formed for the MST :

A->C : B->C : C->D

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
                public int compare(int[] a1, int[] a2) {
                    if(a1[2] != a2[2]) return a1[2]-a2[2];
                    else return (a1[0]+a1[1]+a1[2]) - (a2[0]+a2[1]+a2[2]);
                }
        });
        for(int i = 0; i < m; i++) {
            pq.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }
        Map<Integer,Set<Integer>> hm = new HashMap<Integer,Set<Integer>>();
        for(int i = 1; i <= n; i++) hm.put(i, new HashSet<Integer>(Arrays.asList(i)));
        long ret = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(hm.containsKey(curr[0]) && hm.containsKey(curr[1])) {
                if(hm.get(curr[0]) != hm.get(curr[1])) {
                    ret += curr[2];
                    hm.get(curr[0]).addAll(hm.get(curr[1]));
                    hm.put(curr[1], hm.get(curr[0]));
                }
            }
        }
        System.out.println(ret);
    }
}