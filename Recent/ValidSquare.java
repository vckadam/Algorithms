/* 
593. Valid Square
Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.

*/
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] sides = new double[6];
        sides[0] = distanceBetween(p1,p2);
        sides[1] = distanceBetween(p2,p3);
        sides[2] = distanceBetween(p3,p4);
        sides[3] = distanceBetween(p4,p1);
        sides[4] = distanceBetween(p1,p3);
        sides[5] = distanceBetween(p2,p4);
        Arrays.sort(sides);
        if(sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3] && sides[4] == sides[5] &&
        sides[0] != sides[4]) return true;
        return false;
    }
    
    public double distanceBetween(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p2[0]-p1[0], 2) + Math.pow(p2[1]-p1[1], 2));
    }
    
}