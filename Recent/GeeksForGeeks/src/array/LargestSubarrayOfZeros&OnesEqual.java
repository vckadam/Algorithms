/*
Largest subarray of 0's and 1's

Given an array of 0's and 1's your task is to complete the function maxLen which returns  size of  the  largest sub array with equal number of 0's and 1's .
The function maxLen takes 2 arguments .The first argument is the array A[] and second argument is the size 'N' of the array A[] .

Input:
The first line of the input is T denoting the number of test cases .
Then T test cases follow . Each test case contains two lines . 
The first line of each test case is a number N denoting the size of the array and in the next line are N space separated values of A [ ].

Output:
For each test case output in a new line the max length of the subarray .

Constraints:
1<=T<=100
1<=N<=100
0<=A[ ] <=1

Example:
Input (To be used only for expected output) :
2
4
0 1 0 1
5
0 0 1 0 0 

Output
4
2


Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

**For More Examples Use Expected Output**
*/

/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


class GfG
{
    /*You are required to complete this method*/ 
    int maxLen(int[] arr) 
    {
         int mL = 0, total = 0;
         Map<Integer,Integer> hm = new HashMap<>();
         for(int i = 0; i < arr.length; i++)
            if(arr[i] == 0) 
				arr[i] = -1;  // convert zero to -1 to find maxLen subarray sum equal to zero
         hm.put(0, -1);
         for(int i = 0; i < arr.length; i++) {
             total += arr[i];
             if(hm.containsKey(total)) {
                 int prevInd;
                 if(i - (prevInd = hm.get(total)) > mL) 
                    mL = i - prevInd;
             }
             else 
                hm.put(total, i); // Only put if not exist to get largest length
         }
         return mL;
    }
}