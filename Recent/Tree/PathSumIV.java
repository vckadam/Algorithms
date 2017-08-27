/*
666. Path Sum IV

If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:
Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.
*/

class Solution {
    public int pathSum(int[] nums) {
        if(nums.length == 0)
            return 0;
        Map<String,Integer> sumMap = new HashMap<String,Integer>();
        int D = 0, P = 0;
        for(int i = 0; i < nums.length; i++) {
            D = nums[i] / 100;
            P = nums[i] % 100 / 10 - 1;
            int val = nums[i] % 10;
            String par = (D-1)+"#"+(P/2);
            if(sumMap.containsKey(par)) {
                val += sumMap.get(par);
            }
            sumMap.put(D+"#"+P, val);
        }
        int totalSum = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            D = nums[i] / 100;
            P = nums[i] % 100 / 10 - 1;
            int val = nums[i] % 10;
            String child1 = (D+1)+"#"+(P*2);
            String child2 = (D+1)+"#"+(P*2+1);
            if(!sumMap.containsKey(child1) && !sumMap.containsKey(child2)) {
                totalSum += sumMap.get(D+"#"+P);
            }
        }
        return totalSum;
    }
}