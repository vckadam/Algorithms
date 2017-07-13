/* 
Weighted Uniform Strings

A weighted string is a string of lowercase English letters where each letter has a weight in the inclusive range from  to , defined below:

image

We define the following terms:

The weight of a string is the sum of the weights of all the string's characters. For example:

image

A uniform string is a string consisting of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not (i.e., they consist of more than one distinct character).
Given a string, , let  be the set of weights for all possible uniform substrings (contiguous) of string . You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.

Note: The  symbol denotes that  is an element of set .

Input Format

The first line contains a string denoting  (the original string). 
The second line contains an integer denoting  (the number of queries). 
Each line  of the  subsequent lines contains an integer denoting  (the weight of a uniform subtring of  that may or may not exist).

Constraints

 will only contain lowercase English letters.
Output Format

Print  lines. For each query, print Yes on a new line if ; otherwise, print No instead.

Sample Input 0

abccddde
6
1
3
12
5
9
10
Sample Output 0

Yes
Yes
Yes
Yes
No
No
Explanation 0

The weights of every possible uniform substring in the string abccddde are shown below:

image

We print Yes on the first four lines because the first four queries match weights of uniform substrings of . We print No for the last two queries because there are no uniform substrings in that have those weights.

Note that while de is a substring of  that would have a weight of , it is not a uniform substring.

Note that we are only dealing with contiguous substrings. So ccc is not a substring of the string ccxxc.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WeightedUniformStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        char ch = s.charAt(0);
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch) count++;
            else{
                count = 1;
                ch = s.charAt(i);
            }
            set.add(count*(ch-'a'+1));
        }
        set.add(count*(ch-'a'+1));
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if(set.contains(x)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
