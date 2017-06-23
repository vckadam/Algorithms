/* 
624. Maximum Distance in Arrays
iven m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.

Note:
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].

*/
// Optimized 
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ret = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size()-1);
        for(int i = 1; i < arrays.size(); i++) {
            ret = Math.max(ret, Math.abs(min - arrays.get(i).get(arrays.get(i).size()-1)));
            ret = Math.max(ret, Math.abs(max - arrays.get(i).get(0)));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return ret;
    }
}

// another solution
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int[] min1 = new int[2], min2 = new int[2], max1 = new int[2], max2 = new int[2];
        min1[0] = Integer.MAX_VALUE; min2[0] = Integer.MAX_VALUE;
        max1[0] = Integer.MIN_VALUE; max2[0] = Integer.MIN_VALUE;
        for(int i = 0; i < arrays.size(); i++) {
            if(arrays.get(i).get(0) <= min1[0]) {
                min2[0] = min1[0];
                min1[0] = arrays.get(i).get(0);
                min2[1] = min1[1];
                min1[1] = i;
            }
            else if(arrays.get(i).get(0) <= min2[0]) {
                min2[0] = arrays.get(i).get(0);
                min2[1] = i;
            }
            
            if(arrays.get(i).get(arrays.get(i).size()-1) >= max1[0]) {
                max2[0] = max1[0];
                max1[0] = arrays.get(i).get(arrays.get(i).size()-1);
                max2[1] = max1[1];
                max1[1] = i;
            }
            else if(arrays.get(i).get(arrays.get(i).size()-1) >= max2[0]) {
                max2[0] = arrays.get(i).get(arrays.get(i).size()-1);
                max2[1] = i;
            }
        }
        return min1[1] != max1[1] ? max1[0] - min1[0] : Math.max(max1[0] - min2[0], max2[0] - min1[0]);
    }
}

