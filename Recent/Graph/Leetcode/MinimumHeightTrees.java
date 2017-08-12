/*
310. Minimum Height Trees

For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 0) 
            return new ArrayList<Integer>();
        if(edges.length == 0) 
            return new ArrayList<Integer>(Arrays.asList(0));
        int[] indegree = new int[n];
        int numOfNodes = n;
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int[] edge : edges) {
            putInMap(adjMap,edge[0],edge[1]);
            putInMap(adjMap,edge[1],edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        List<Integer> curr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
            if(indegree[i] == 1)
                curr.add(i);
        while(curr.size() > 0 && numOfNodes > 2) {
            List<Integer> next = new ArrayList<Integer>();
            for(int i = 0; i < curr.size(); i++) {
                List<Integer> neighbours = adjMap.get(curr.get(i));
                for(Integer neighbour : neighbours) {
                    if(--indegree[neighbour] == 1)
                        next.add(neighbour);
                }
            }
            numOfNodes -= curr.size();
            curr = next;
        }
        return curr;
    }
    
    public void putInMap(Map<Integer,List<Integer>> hm, int key, int val) {
        if(!hm.containsKey(key))
            hm.put(key, new ArrayList<Integer>(Arrays.asList(val)));
        else 
            hm.get(key).add(val);
    }
}