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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
points

group the collinear points form set of points are return max group size

		array[0] = new LinePoint(-6,-5);
		array[1] = new LinePoint(-3,-3);
		array[2] = new LinePoint(0,0);
		array[3] = new LinePoint(3,1);
		array[4] = new LinePoint(6,3);
		array[5] = new LinePoint(1,1);
		array[6] = new LinePoint(2,2);
		array[7] = new LinePoint(3,3);
		array[8] = new LinePoint(4,4);
		System.out.println(isCollinear(array));
		
output 
(3,1)(-6,-5)(-3,-3)(6,3)
(1,1)(2,2)(0,0)(4,4)(-3,-3)(3,3)
6

import java.util.*;
class LinePoint {
	int x;
	int y;
	LinePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class ColinearPointMain {
	public static boolean collinear(LinePoint p1, LinePoint p2, LinePoint p3) {
		return (p2.y - p1.y)*(p3.x-p2.x) == (p3.y-p2.y)*(p2.x-p1.x);
	}
	public static int isCollinear(LinePoint[] array) {
		if(array.length == 0 || array.length == 1) return array.length;
		ArrayList<Set<LinePoint>> resultlist = new ArrayList<Set<LinePoint>>();
		int result = 2, count;
		for(int i = 0; i < array.length; i++) {
			for(int j = i+1; j < array.length; j++) {
				count = 2;
				Set<LinePoint> current = new HashSet<LinePoint>();
				current.add(array[i]);
				current.add(array[j]);
				for(int k = 0; k < array.length; k++)  {
					if(k == i || k == j) continue;
					if(collinear(array[i],array[j],array[k])) {						
						current.add(array[k]);
						count++;
					}
				}
				if(current.size()>2 && !resultlist.contains(current)) resultlist.add(current);
				result = Math.max(count, result);
			}
		}
		for(int i = 0; i < resultlist.size(); i++) {
			for(LinePoint p: resultlist.get(i)) {
				System.out.print("("+p.x+","+p.y+")");
			}
			System.out.println();
		}
		return result;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
remove dublicate points 

(2,3),(2,5), (2,2),(2,6),(2,6),(2,5),(2,2),(2,3),(2,2)

output : (2,2)(2,3)(2,5)(2,6)

class LinePoint implements Comparator<LinePoint>{
	int x;
	int y;
	LinePoint() { }
	LinePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compare(LinePoint p1, LinePoint p2) {
		if(p1.x != p2.x) return p1.x-p2.x;
		else return p1.y-p2.y;
	}
	
}

	public static LinePoint[] removeDublicate(LinePoint[] array) {
		Arrays.sort(array, new LinePoint());
		int i = 0, j = -1;
		while(i < array.length) {
			if(i == 0) {
				array[++j] = array[i++];
			}
			else {
				if(array[j].x == array[i].x && array[j].y == array[i].y) i++;
				else array[++j] = array[i++];
			}
		}
		LinePoint[] result = new LinePoint[j+1];
		for(i = 0; i < result.length;i++) {
			result[i] = array[i];
			System.out.print("("+array[i].x+","+array[i].y+")");
		}
		return result;
	}
