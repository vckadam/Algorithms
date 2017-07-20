/*

QHEAP1

This question is designed to help you get a better understanding of basic heap operations. 
You will be given queries of  types:

" " - Add an element  to the heap.
" " - Delete the element  from the heap.
"" - Print the minimum of all the elements in the heap.
NOTE: It is guaranteed that the element to be deleted will be there in the heap. Also, at any instant, only distinct elements will be in the heap.

Input Format

The first line contains the number of queries, . 
Each of the next  lines contains a single query of any one of the  above mentioned types.

Constraints 
 

Output Format

For each query of type , print the minimum value on a single line.

Sample Input

5  
1 4  
1 9  
3  
2 4  
3  
Sample Output

4  
9 
Explanation

After the first  queries, the heap contains {}. Printing the minimum gives  as the output. Then, the  query deletes  from the heap, and the  query gives  as the output

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < n; i++) {
            int status = sc.nextInt();
            if(status == 1) {
                int num = sc.nextInt();
                list.add(num);
                hm.put(num, list.size()-1);
                for(int par = getParent(list.size()-1,list); par >= 0;) {
                    heapify(par,list,hm);
                    par = getParent(par,list);
                }
            } else if(status == 2) {
                int num = sc.nextInt();
                int ind = hm.get(num);
                if(ind < list.size()-1) {
                    swap(list,ind,list.size()-1, hm);
                }
                list.remove(list.size()-1);
                hm.remove(num);
                heapify(ind, list, hm);
            } else {
                System.out.println(list.get(0));
            }
        }
    }
    
    public static void heapify(int ind, List<Integer> list, Map<Integer,Integer> hm) {
        int leftInd = getLeftChild(ind, list);
        int rightInd = getRightChild(ind, list);
        int min = ind;
        if(leftInd != -1 && list.get(leftInd) < list.get(ind)) min = leftInd;
        if(rightInd != -1 && list.get(rightInd) < list.get(min)) min = rightInd;
        if(min != ind) {
            swap(list, ind, min, hm);
            heapify(min, list, hm);
        }
    }
    
    public static void swap(List<Integer> list, int i, int j, Map<Integer,Integer> hm) {
        hm.put(list.get(i), j);
        hm.put(list.get(j), i);
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    public static int getParent(int ind, List<Integer> list) {
        return ind == 0 ? -1 : (ind - 1) / 2;
    }
    public static int getLeftChild(int ind, List<Integer> list) {
        return (2 * ind + 1) < list.size() ? (2 * ind + 1) : -1;
    }
    public static int getRightChild(int ind, List<Integer> list) {
        return (2 * ind + 2) < list.size() ? (2 * ind + 2) : -1;
    }
}