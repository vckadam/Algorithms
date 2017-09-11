/*
675. Cut Off Trees for Golf Event

You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:
Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
Example 2:
Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
Example 3:
Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
Hint: size of the given matrix will not exceed 50x50.
*/

class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.size() == 0)
            return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        populatePQ(forest,pq);
        int startI = 0, startJ = 0, steps = 0;
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            //System.out.println(Arrays.toString(temp));
            int currSteps = bfs(forest,startI,startJ,temp[1],temp[2]);
            //System.out.println(currSteps);
            if(currSteps == -1)
                return -1;
            steps += currSteps;
            startI = temp[1]; startJ = temp[2];
            forest.get(startI).set(startJ, 1);
        }
        return steps;
    }
    
    public int bfs(List<List<Integer>> forest, int startI, int startJ, int endI, int endJ) {
        if(startI == endI && startJ == endJ) 
            return 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        queue.add(new int[]{startI,startJ});
        visited[startI][startJ] = true;
        int level = 0;
        while(!queue.isEmpty()) {
            int currSize = queue.size();
            for(int i = 0; i < currSize; i++) {
                int[] temp= queue.poll();
                if(temp[0] == endI && temp[1] == endJ) 
                    return level;
                if(temp[0] > 0 && forest.get(temp[0]-1).get(temp[1]) != 0 && !visited[temp[0]-1][temp[1]]) {
                    queue.offer(new int[]{temp[0]-1,temp[1]});
                    visited[temp[0]-1][temp[1]] = true;
                }
                if(temp[0] < forest.size()-1 && forest.get(temp[0]+1).get(temp[1]) != 0 && !visited[temp[0]+1][temp[1]]) {
                    queue.offer(new int[]{temp[0]+1,temp[1]});
                    visited[temp[0]+1][temp[1]] = true;
                }
                if(temp[1] > 0 && forest.get(temp[0]).get(temp[1]-1) != 0 && !visited[temp[0]][temp[1]-1]) {
                    queue.offer(new int[]{temp[0],temp[1]-1});
                    visited[temp[0]][temp[1]-1] = true;
                }
                if(temp[1] < forest.get(temp[0]).size()-1 && forest.get(temp[0]).get(temp[1]+1) != 0 && !visited[temp[0]][temp[1]+1]) {
                    queue.offer(new int[]{temp[0],temp[1]+1});
                    visited[temp[0]][temp[1]+1] = true;
                }
            }
            level++;
        }
        return -1;
    }
    
    public void populatePQ(List<List<Integer>> forest, PriorityQueue<int[]> pq) {
        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                if(forest.get(i).get(j) > 1)
                    pq.add(new int[]{forest.get(i).get(j),i,j});
            }
        }
    }
}