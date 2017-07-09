/* 
640. Solve the Equation

Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"

*/

public class SolveTheEquation {
    public String solveEquation(String equation) {
        String[] strA = equation.split("=");
        int[] A1 = getArray(strA[0]);
        int[] A2 = getArray(strA[1]);
        if(A1[0] == A2[0] && A1[1] == A2[1]) return "Infinite solutions";
        if(A1[0] == 0 && A2[0] == 0) return "No solution";
        if(A1[1] == 0 && A2[1] == 0) return "x=0";
        int[] last = new int[2];
        last[0] = A1[0] - A2[0];
        last[1] = A2[1] - A1[1];
        if(last[0] == 0) return "No solution";
        if(last[0] != 0) last[1] /= Math.abs(last[0]);
        if(last[0] < 0) last[1] *= -1;
        return "x="+last[1];
    }
    public int[] getArray(String str) {
        int[] ret = new int[2];
        int sign = 1;
        if(str.charAt(0) == '-') {
            str = str.substring(1);
            sign = -1;
        }
        String[] strA = str.split("-|\\+");
        int i = 0, j = strA[0].length();
        for(; i < strA.length; i++) { 
            if(i > 0) sign = (str.charAt(j) == '-') ? -1 : 1;
            if(strA[i].charAt(strA[i].length()-1) == 'x') {                
                    ret[0] += (strA[i].length() == 1 ? sign * 1: sign*Integer.valueOf(strA[i].substring(0,strA[i].length()-1)));
            } else {
                ret[1] += (sign* Integer.valueOf(strA[i]));
            }
            if(i > 0) j += (strA[i].length()+1);
        }
        return ret;
    }
}