/*
659. Split Array into Consecutive Subsequences

You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
Note:
The length of the input is in range of [1, 10000]

*/
public class Solution {
    public boolean isPossible(int[] nums) {
        if(nums.length == 0 || nums.length < 3)
            return false;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] != b[0])?a[0]-b[0]:a[1]-b[1]);
        List<int[]> list = new ArrayList<int[]>();
        for(int i = 0; i < nums.length; i++) {
            while(!pq.isEmpty() && pq.peek()[0] < nums[i]-1)
                list.add(pq.poll());
            if(pq.isEmpty() || pq.peek()[0] == nums[i]) 
                pq.add(new int[]{nums[i],1});
            else {
                int[] temp = pq.poll();
                temp[0] = nums[i];
                temp[1]++;
                pq.add(temp);
            }
        }
        while(!pq.isEmpty()) 
            list.add(pq.poll());
        for(int i = 0; i < list.size(); i++) {
            //System.out.println(Arrays.toString(list.get(i)));
            if(list.get(i)[1] < 3)
                return false;
        }
            
        return true;
    }
}