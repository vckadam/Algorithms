/*
207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 || prerequisites == null) 
            return false;
        int[] indegree = new int[numCourses];
        int count = 0;
        Map<Integer,List<Integer>> adjMap = new HashMap<Integer,List<Integer>>();
        for(int[] edge : prerequisites) {
            if(edge != null) {
                indegree[edge[0]]++;
                if(!adjMap.containsKey(edge[1])) adjMap.put(edge[1], new ArrayList<Integer>());
                adjMap.get(edge[1]).add(edge[0]);
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++) 
            if(indegree[i] == 0)
                q.offer(i);
        while(!q.isEmpty()) {
            int temp = q.poll();
            count++;
            if(adjMap.containsKey(temp)) {
                List<Integer> neighbours = adjMap.get(temp);
                for(Integer neighbour : neighbours) 
                    if(--indegree[neighbour] == 0)
                        q.offer(neighbour);
            }
        }
        return count == numCourses;
    }
}