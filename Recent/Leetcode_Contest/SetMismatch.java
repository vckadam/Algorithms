/*
645. Set Mismatch My SubmissionsBack to Contest
User Accepted: 1469
User Tried: 1604
Total Accepted: 1513
Total Submissions: 3783
Difficulty: Easy
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
*/
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        for(int i = 1; i <= nums.length; i++) {
            xor ^= i;
            xor ^= (nums[i-1]);
        }
        int[] ret = new int[2];
        int rightMost = xor & (~xor + 1);
        for(int i = 1; i <= nums.length; i++) {
            if((i & rightMost) == 0) ret[0]^= i;
            else ret[1] ^= i;
            if((nums[i-1] & rightMost) == 0) ret[0] ^= nums[i-1];
            else ret[1] ^= nums[i-1];
        }
        for(int i = 1; i <= nums.length; i++) {
            if(ret[1] == nums[i-1]) {
                int temp = ret[0];
                ret[0] = ret[1];
                ret[1] = temp;
                break;
            }
        }
        return ret;
    }
}