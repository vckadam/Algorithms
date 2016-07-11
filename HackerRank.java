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
