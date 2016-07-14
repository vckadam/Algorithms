Given two points P and Q, output the symmetric point of point P about Q.

Input Format 
The first line contains an integer  representing the number of testcases 
Each test case is a line containing four space separated integers  representing the  coordinates of  and .

Constraints 
 

Output Format 
For each test case output x and y coordinates of the symmetric point (each point in a new line).

Sample Input

2
0 0 1 1
1 1 2 2
Sample Output

2 2
3 3

	public static void symmaticPoints(int px, int py, int qx, int qy) {
        System.out.println((qx + (qx-px))+" "+(qy + (qy-py)));
        return;
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine().trim());
       int px, py, qx, qy;
       for(int i = 0; i < n; i++) {
           String[] str = (br.readLine().trim()).split(" ");
           px = Integer.parseInt(str[0]);
           py = Integer.parseInt(str[1]);
           qx = Integer.parseInt(str[2]);
           qy = Integer.parseInt(str[3]);
           symmaticPoints(px,py,qx,qy);
       }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Maximum Draws
Jim is off to a party and is searching for a matching pair of socks. His drawer is filled with socks, each pair of a different color. In its worst case scenario, how many socks (x) should Jim remove from his drawer until he finds a matching pair?

Input Format 
The first line contains the number of test cases T. 
Next T lines contains an integer N which indicates the total pairs of socks present in the drawer.

Output Format 
Print the number of Draws (x) Jim makes in the worst case scenario.

Constraints 
 

Sample Input

2
1
2
Sample Output

2
3
Explanation 
Case 1 : A pair of socks are present, hence exactly 2 draws for the socks to match. 
Case 2 : 2 pair of socks are present in the drawer. The first and the second draw might result in 2 socks of different color. The 3rd sock picked will definitely match one of previously picked socks. Hence, 3.

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            System.out.println(Integer.parseInt(br.readLine().trim())+1);
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
There are two kangaroos on an x-axis ready to jump in the positive direction (i.e, toward positive infinity). The first kangaroo starts at location  and moves at a rate of  meters per jump. The second kangaroo starts at location  and moves at a rate of  meters per jump. Given the starting locations and movement rates for each kangaroo, can you determine if they'll ever land at the same location at the same time?

Input Format

A single line of four space-separated integers denoting the respective values of , , , and .

Constraints

Output Format

Print YES if they can land on the same location at the same time; otherwise, print NO.

Note: The two kangaroos must land at the same location after making the same number of jumps.

Sample Input 0

0 3 4 2
Sample Output 0

YES
Explanation 0

The two kangaroos jump through the following sequence of locations:

Thus, the kangaroos meet after  jumps and we print YES.

Sample Input 1

0 2 5 3
Sample Output 1

NO
Explanation 1

The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's starting location (i.e., ). Because the second kangaroo moves at a faster rate (meaning ) and is already ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO.

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        while(x1 <= x2) {
            if(x1 == x2) {
                System.out.println("YES");
                return;
            }
            x1+=v1;
            x2+=v2;
        }
        System.out.println("NO");
    }
}
///////////////////////////////////////////////////////////////////////////////////////////
You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

Note: An empty stack is still a stack.

Input Format

The first line contains three space-separated integers, , , and , describing the respective number of cylinders in stacks , , and . The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

The second line contains  space-separated integers describing the cylinder heights in stack .
The third line contains  space-separated integers describing the cylinder heights in stack .
The fourth line contains  space-separated integers describing the cylinder heights in stack .
Constraints

Output Format

Print a single integer denoting the maximum height at which all stacks will be of equal height.

Sample Input

5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
Sample Output

5

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int he1 = 0, he2 = 0, he3 = 0;
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            he1 += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            he2 += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            he3 += h3[h3_i];
        }
        int i = 0, j = 0, k = 0;
        while( i < n1 && j < n2 && k <  n3) {
            if(he1 == he2 && he1 == he3) {
                System.out.println(he1); return;
            }
            if(he1 >= he2 && he1 >= he3) he1-=h1[i++];
            else if(he2 >= he1 && he2 >= he3) he2-=h2[j++];
            else he3 -=h3[k++];
        }
        System.out.println(0);
    }
//////////////////////////////////////////////////////////////////////////////////////

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        while(true) {
            int count = 0, min = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > 0) {
                    count++;
                    min = Math.min(min,arr[i]);
                }
            }
            if(count > 0)
            System.out.println(count);
            else break;
            for(int i = 0; i < arr.length; i++) arr[i]-=min;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////
t's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!

There are  people queued up, and each person wears a sticker indicating their initial position in the queue (i.e.:  with the first number denoting the frontmost position).

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original place in line. One person can bribe at most two other persons.

That is to say, if  and  bribes , the queue will look like this: .

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

Note: Each  wears sticker , meaning they were initially the  person in queue.

Input Format

The first line contains an integer, , denoting the number of test cases. 
Each test case is comprised of two lines; the first line has  (an integer indicating the number of people in the queue), and the second line has  space-separated integers describing the final state of the queue.

Constraints



Subtasks

For  score 
For  score 

Output Format

Print an integer denoting the minimum number of bribes needed to get the queue into its final state; print Too chaotic if the state is invalid (requires  to bribe more than  people).

Sample Input

2
5
2 1 5 3 4
5
2 5 1 3 4
Sample Output

3
Too chaotic

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            int count = 0,i;
            for(i = n-1; i >= 0 ;i--) {
                //if(q[i] == i + 1) continue;
                if(q[i] - i - 1 > 2) {
                    System.out.println("Too chaotic");
                    break;
                }
                for(int j = Math.max(0,q[i]-2); j < i ; j++) {
                    if(q[j] > q[i]) count++;
                }
                
            }
            if(i >= 0) continue;
            System.out.println(count);
        
        }  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Lisa's Workbook

Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters.

There are  chapters in Lisa's workbook, numbered from  to .
The -th chapter has  problems, numbered from  to .
Each page can hold up to  problems. There are no empty pages or unnecessary spaces, so only the last page of a chapter may contain fewer than  problems.
Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
The page number indexing starts at .
Lisa believes a problem to be special if its index (within a chapter) is the same as the page number where it's located. Given the details for Lisa's workbook, can you count its number of special problems?

Note: See the diagram in the Explanation section for more details.

Input Format

The first line contains two integers  and  — the number of chapters and the maximum number of problems per page respectively. 
The second line contains  integers , where  denotes the number of problems in the -th chapter.

Constraints

Output Format

Print the number of special problems in Lisa's workbook.

Sample Input

5 3  
4 2 6 1 10
Sample Output

4
Explanation

The diagram below depicts Lisa's workbook with  chapters and a maximum of  problems per page. Special problems are outlined in red, and page numbers are in yellow squares.

bear_workbook.png

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++)  array[i] = sc.nextInt();
        int j = 1, count = 0;
        for(int i = 0; i < n; i++) {
            int ch = 1;
            while(ch <= array[i]) {
                if(j >= ch && j <= ch+k-1){
                    if(ch+k-1 <= array[i]) {
                        count++;
                    }
                    else {
                        //int remain = array[i] - ch;
                        if(j <= array[i]) count++;
                    }
                } 
                
                ch+=k;
                j++;
            }
        }
        System.out.println(count);
    }
//////////////////////////////////////////////////////////////////////////////////////////////
The Bomberman Game

Bomberman lives in a rectangular grid with  rows and  columns. Each cell in the grid either contains a bomb or nothing at all.

Each bomb can be planted in any cell of the grid but, once planted, it will detonate after exactly 3 seconds. Once a bomb detonates, it's destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell , cells  and  are cleared (note that cells at the edge of the grid have less than four neighboring cells). If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating (i.e., no chain reaction occurs).

Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:

Initially, Bomberman arbitrarily plants bombs in some of the cells.
After one second, Bomberman does nothing.
After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. It is guaranteed that no bombs will detonate at this second.
After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
Bomberman then repeats steps 3 and 4 indefinitely.
Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.

Given the initial configuration of the grid with the locations of Bomberman's first batch of planted bombs, determine the state of the grid after  seconds.

Input Format

The first line contains three space-separated integers denoting the respective values of , , and . 
Each line  of the  subsequent lines describes row  of the grid's initial state as a single string of  characters; the . character denotes an empty cell, and the O character (ascii 79) denotes a bomb.

Constraints

Subtask

 for  of the maximum score.
Output Format

Print the grid's final state. This means  lines where each line contains  characters, and each character is either a . or an O (ascii 79). This grid must represent the state of the grid after  seconds.

Sample Input

6 7 3
.......
...O...
....O..
.......
OO.....
OO.....
Sample Output

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO
Explanation

The initial state of the grid is:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman spends the first second doing nothing, so this is the state after 1 second:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman plants bombs in all the empty cells during his second second, so this is the state after 2 seconds:

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
In his third second, Bomberman sits back and watches all the bombs he planted 3 seconds ago detonate. This is the final state after  seconds:

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        int r = Integer.valueOf(str1[0]);
        int c = Integer.valueOf(str1[1]);
        int sec = Integer.valueOf(str1[2]);
        char[][] array = new char[r][c];
        for(int i = 0; i < r; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < c; j++) {
                array[i][j] = str.charAt(j);
            }
            
        }
        int k = 1; 
        for(; k <= sec; k++) {
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(array[i][j] == 'O') array[i][j] = '1';
                    else if(array[i][j] == '1') array[i][j] = '2';
                    else if(array[i][j] == '2'){
                        array[i][j] = '3';
                        if(i > 0 && array[i-1][j] != '2') array[i-1][j] = '3';
                        if(j > 0 && array[i][j-1] != '2') array[i][j-1] = '3';
                        if(i < r-1 && array[i+1][j] != '2') array[i+1][j] = '3';
                        if(j < c-1 && array[i][j+1] != '2') array[i][j+1] = '3';
                    } 
                    else if(k % 2 == 0 && array[i][j] == '.') array[i][j] = 'O';
                    
                }
                
            }
            //System.out.println();
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(array[i][j] == '3') array[i][j] = '.';
                    //System.out.print(array[i][j]);
                }
                //System.out.println();
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(array[i][j] == '1' || array[i][j] == '2') System.out.print('O');
                else System.out.print(array[i][j]);
            }
            System.out.println();
        }
       
        
    }
/////////////////////////////////////////////////////////////////////////////////////////
Super Reduced String

Shil has a string, , consisting of  lowercase English letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "" would become either "" or "" after  operation.

Shil wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Shil out by finding and printing 's non-reducible form!

Note: If the final string is empty, print .

Input Format

A single string, .

Constraints

Output Format

If the final string is empty, print ; otherwise, print the final non-reducible string.

Sample Input 0

aaabccddd
Sample Output 0

abd
Sample Input 1

baab
Sample Output 1

Empty String
Sample Input 2

aa
Sample Output 2

Empty String
Explanation

Sample Case 0: 
Shil can perform the following sequence of operations to get the final string:

Thus, we print .

Sample Case 1: 
Shil can perform the following sequence of operations to get the final string:


public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine().trim());
        int ptr = -1, i = 0;
        while(i < sb.length()) {
            if(ptr == -1 || sb.charAt(ptr) != sb.charAt(i)) {
                sb.setCharAt(++ptr, sb.charAt(i++));
            }
            else {
                i++; ptr--;
            }
        }
        System.out.println((ptr == -1)?"Empty String":sb.substring(0,ptr+1));
    }	
////////////////////////////////////////////////////////////////////////////////////////////////////////
Beautiful Binary String

Alice has a binary string, , of length . She thinks a binary string is beautiful if and only if it doesn't contain the substring .

In one step, Alice can change a  to a  (or vice-versa). Count and print the minimum number of steps needed to make Alice see the string as beautiful.

Input Format

The first line contains an integer,  (the length of binary string ). 
The second line contains a single binary string, , of length .

Constraints

Each character in .
Output Format

Print the minimum number of steps needed to make the string beautiful.

Sample Input 0

7
0101010
Sample Output 0

2
Sample Input 1

5
01100
Sample Output 1

0
Sample Input 2

10
0100101010
Sample Output 2

3

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String sb = in.next();
        int i = 0,count = 0;
        while(i <= sb.length()-3) {
            if(sb.substring(i,i+3).equals("010")) {
                count++;
                i+=3;
            }
            else i++;
        }
        System.out.println(count);
    }
////////////////////////////////////////////////////////////////////////////////////////// 

The Love-Letter Mystery

ames found a love letter his friend Harry has written for his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.

To do this, he follows two rules:

He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
In order to form a palindrome, if he has to repeatedly reduce the value of a letter, he can do it until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.
Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.

Input Format

The first line contains an integer , i.e., the number of test cases. 
The next  lines will contain a string each. The strings do not contain any spaces.

Constraints 
 
 length of string  
All characters are lower case English letters.

Output Format

A single line containing the number of minimum operations corresponding to each test case.

Sample Input

4
abc
abcba
abcd
cba
Sample Output

2
0
4
2
Explanation

For the first test case, abc -> abb -> aba.
For the second test case, abcba is already a palindromic string.
For the third test case, abcd -> abcc -> abcb -> abca = abca -> abba.
For the fourth test case, cba -> bba -> aba.

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            int count = 0, left = 0, right = str.length()-1;
            while(left < right) {
               count+=Math.abs(str.charAt(left++)-str.charAt(right--));
            }
            System.out.println(count);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////
Richie Rich

Sandy likes palindromes. A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward as it does forward. For example, madam is a palindrome.

On her  birthday, Sandy's uncle, Richie Rich, offered her an -digit check which she refused because the number was not a palindrome. Richie then challenged Sandy to make the number palindromic by changing no more than  digits. Sandy can only change  digit at a time, and cannot add digits to (or remove digits from) the number.

Given  and an -digit number, help Sandy determine the largest possible number she can make by changing digits.

Note: Treat the integers as numeric strings. Leading zeros are permitted and can't be ignored (So 0011 is not a palindrome, 0110 is a valid palindrome). A digit can be modified more than once.

Input Format

The first line contains two space-separated integers,  (the number of digits in the number) and  (the maximum number of digits that can be altered), respectively. 
The second line contains an -digit string of numbers that Sandy must attempt to make palindromic.

Constraints

Each character  in the number is an integer where .
Output Format

Print a single line with the largest number that can be made by changing no more than  digits; if this is not possible, print -1.

Sample Input 0

4 1
3943
Sample Output 0

3993
Sample Input 1

6 3
092282
Sample Output 1

992299
Sample Input 2

4 1
0011
Sample Output 2

-1

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        StringBuilder sb = new StringBuilder(number);
        int left = 0, right = number.length()-1;
        while(left < right) {
            if(sb.charAt(left) != sb.charAt(right)) {
                if(k == 0) {
                    System.out.println(-1); return;
                }
                else {
                    k--;
                    if(sb.charAt(left) > sb.charAt(right)) sb.setCharAt(right, sb.charAt(left));
                    else sb.setCharAt(left, sb.charAt(right));
                }
            }
            left++; right--;
        }
        left = 0; right = number.length()-1;
        while(left < right) {
            if(k == 0) break;
            if(sb.charAt(left) == '9'){
                left++; right--;
                continue;
            }
            if(number.charAt(left) != number.charAt(right)) k++;
            if(k >= 2) {
                sb.setCharAt(left, '9');
                sb.setCharAt(right, '9');
                k-=2;
            }
            left++;
            right--;
        }
        if(k > 0) sb.setCharAt(left,'9');
        System.out.println(sb.toString());
    }
//////////////////////////////////////////////////////////////////////////////////////////

Palindrome Index

Given a string, , of lowercase letters, determine the index of the character whose removal will make  a palindrome. If  is already a palindrome or no such character exists, then print . There will always be a valid solution, and any correct answer is acceptable. For example, if  "bcbc", we can either remove 'b' at index  or 'c' at index .

Input Format

The first line contains an integer, , denoting the number of test cases. 
Each line  of the  subsequent lines (where ) describes a test case in the form of a single string, .

Constraints

All characters are lowercase English letters.
Output Format

Print an integer denoting the zero-indexed position of the character that makes  not a palindrome; if  is already a palindrome or no such character exists, print .

Sample Input

3
aaab
baa
aaa
Sample Output

3
0
-1

public static boolean isPalindrome(String str) {
        int left = 0, right = str.length()-1;
        while(left < right) if(str.charAt(left++) != str.charAt(right--)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            if(str.length() <= 1) {
                System.out.println("-1"); continue;
            }
            int left = 0, right = str.length()-1;
            while(left < right) {
                if(str.charAt(left) == str.charAt(right)) {
                    left++; right--;
                }
                else {
                    if(str.charAt(left+1)== str.charAt(right)) {
                        System.out.println(left); break;
                    }
                    else if(str.charAt(right-1) == str.charAt(left)) {System.out.println(right); break;}
                    else {
                        System.out.println("-1"); break;
                    }
                }
            }
            if(left >= right) System.out.println("-1");
        }
    }   