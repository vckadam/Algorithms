/*
Waiter

You are a waiter at a party. There are  stacked plates on pile . Each plate has a number written on it. Then there will be  iterations. In -th iteration, you start picking up the plates in  from the top one by one and check whether the number written on the plate is divisible by the -th prime. If the number is divisible, you stack that plate on pile . Otherwise, you stack that plate on pile . After  iterations, plates can only be on pile , . Output numbers on these plates from top to bottom of each piles in order of , .

Input Format

The first line contains two space separated integers,  and . 
The next line contains  space separated integers representing the initial pile of plates, i.e., . The leftmost value represents the bottom plate of the pile.

Constraints

 
 

Output Format

Output  lines. Each line contains a number written on the plate. Printing should be done in the order defined above.

Sample Input 0

5 1
3 4 7 6 5
Sample Output 0

4
6
3
7
5
Explanation 0

Initially:

 = [3, 4, 7, 6, 5]<-TOP

After 1 iteration:

 = []<-TOP

 = [6, 4]<-TOP

 = [5, 7, 3]<-TOP

We should output numbers in  first from top to bottom, and then output numbers in  from top to bottom.

Sample Input 1

5 2
3 3 4 4 9
Sample Output 1

4
4
9
3
3
Explanation 1

Initially:

 = [3, 3, 4, 4, 9]<-TOP

After  iteration:

 = []<-TOP

 = [4, 4]<-TOP

 = [3, 3, 9]<-TOP

After  iteration:

 = []<-TOP

 = [4, 4]<- TOP

 = [3, 3, 9]<-TOP

We should output numbers in  first from top to bottom, and then output numbers in  from top to bottom.

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] number = new int[n];
        Stack<Integer> curr = new Stack<Integer>();
        for(int number_i = 0; number_i < n; number_i++){
            number[number_i] = in.nextInt();
            curr.push(number[number_i]);
        }
        List<Integer> prime = getPrime(); 
        Queue<Stack<Integer>> queue = new LinkedList<Stack<Integer>>();
        int i = 0;
        while(i < q) {
            Stack<Integer> b = new Stack<Integer>();
            Stack<Integer> a = new Stack<Integer>();
            while(!curr.isEmpty()) {
                int temp = curr.pop();
                if(temp % prime.get(i) == 0) b.push(temp);
                else a.push(temp);
            }
            queue.offer(b);
            curr = a;
            i++;
        }
        while(!queue.isEmpty()) {
            Stack<Integer> currStack = queue.poll();
            while(!currStack.isEmpty()) {
                System.out.println(currStack.pop());
            }
        }
        while(!curr.isEmpty()) System.out.println(curr.pop());
    }
    
    public static List<Integer> getPrime() {
        int n = 10000;
        boolean[] array = new boolean[n];
        for(int i = 2; i * i < n; i++) {
            for(int j = i*i; j < n; j+=i) {
                array[j] = true;
            }
        }
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 2; i < n; i++) if(!array[i]) ret.add(i);
        return ret;
    }
}

