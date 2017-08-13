/*
658. Find K Closest Elements

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
*/

public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> ret = new ArrayList<Integer>();
        if(arr.size() == 0) 
            return ret;
        int ind = getInsertPos(arr, x);
        k--;
        if(k == 0)
            return arr.subList(ind,ind+1);
        int left = ind-1, right = ind+1;
        while(k-- > 0) {
            if(left < 0 && right >= arr.size())
                break;
            else if(left < 0) 
                right++; 
            else if(right >= arr.size())
                left--;
            else 
                if(Math.abs(x-arr.get(left))<=Math.abs(x-arr.get(right)))
                    left--;
                else 
                    right++;
        }
        return arr.subList(left+1,right);        
    }
    public int getInsertPos(List<Integer> arr, int x) {
        /*
            1 3 6 8 10
        */
        int n;
        if(arr.size() == 1 || x < arr.get(0))  //always think for single element.
            return 0; 
        if(x > arr.get((n = arr.size()-1)))
            return n;
        int left = 0, right = n;
        while(left < right) {
            int mid =(left + right + 1)/2;
            if(x == arr.get(mid)) 
                return mid;
            else if(x > arr.get(mid)) 
                left = mid;
            else 
                right = mid - 1;
        } 
        return (Math.abs(arr.get(left)-x) <= Math.abs(arr.get(left+1)-x)) ? left : left+1;
    }
}