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
