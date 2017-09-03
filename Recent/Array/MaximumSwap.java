/*
670. Maximum Swap

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 10^8]

*/

class Solution {
    public int maximumSwap(int num) {
        if(num >= 0 && num <= 9)
            return num;
        int[] numA = getArray(num);
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 9; i >= 0; i--) {
            if(s.isEmpty() || numA[s.peek()] <= numA[i])
                s.push(i);
        }
        int k = 0;
        while(k < 10 && numA[k] == 0) k++;
        while(k < 10 && !s.isEmpty()) {
            int ind;
            if(numA[k++] != numA[(ind = s.pop())]) {
                while(!s.isEmpty() && numA[ind] == numA[s.peek()]) 
                    ind = s.pop();
                swap(numA,k-1,ind);
                break;
            }
        }
        return getNum(numA);
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int getNum(int[] array) {
        int k = 0, ret = 0;
        while(k < array.length && array[k] == 0) k++;
        while(k < array.length) {
            ret = 10 * ret + array[k++];
        }
        return ret;
    }
    
    public int[] getArray(int num) {
        int[] array = new int[10];
        int k = 9;
        while(num > 0) {
            array[k--] = num % 10;
            num /= 10;
        }
        return array;
    }
}