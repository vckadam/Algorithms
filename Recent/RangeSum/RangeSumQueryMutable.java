/* 
307. Range Sum Query - Mutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.

*/

public class NumArray {

    int[] nums, array;
    public NumArray(int[] nums) {
        this.nums = nums;
        array = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            fillArray(nums[i],i+1);
        }
    }
    
    public void update(int i, int val) {
        fillArray(val-nums[i], i+1);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return getSum(j+1);
        return getSum(j+1) - getSum(i);
    }
    
    public int getSum(int i) {
        int ret = 0;
        while(i > 0) {
            ret += array[i];
            i = getParent(i);
        }
        return ret;
    }
    
    public void fillArray(int num, int ind) {
        while(ind < array.length) {
            array[ind]+=num;
            ind = getNext(ind);
        }
    }
    
    public int getNext(int ind) {
        return ind + (ind & (~ind + 1));
    }
    
    public int getParent(int ind) {
        return ind - (ind & (~ind + 1));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */