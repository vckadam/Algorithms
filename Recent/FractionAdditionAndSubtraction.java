/* 
592. Fraction Addition and Subtraction
Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

Example 1:
Input:"-1/2+1/2"
Output: "0/1"
Example 2:
Input:"-1/2+1/2+1/3"
Output: "1/3"
Example 3:
Input:"1/3-1/2"
Output: "-1/6"
Example 4:
Input:"5/3+1/3"
Output: "2/1"
Note:
The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1,10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
*/
public class Solution {
    public String fractionAddition(String expression) {
        if(expression.length() <= 4) return expression;
        int sign = 1;
        if(expression.charAt(0) == '-') {
            sign = -1;
            expression = expression.substring(1);
        }
        String[] exprs = expression.split("[+-]+");
        int[][] values = new int[exprs.length][2];
        int i = 0;
        for(String expr : exprs) {
            String[] ex = expr.split("/");
            values[i][0] = Integer.parseInt(ex[0]);
            values[i++][1] = Integer.parseInt(ex[1]);
        }
        i = 1; 
        values[0][0] = values[0][0] * sign;
        for(int j = exprs[0].length(); j < expression.length(); i++) {
            if(expression.charAt(j) == '-') values[i][0] = -values[i][0];
            j = j + exprs[i].length() + 1;
        }
        for(int k = 1; k < values.length; k++) {
            int[] temp = new int[2];
            int lcm = LCM(values[0][1], values[k][1]);
            values[0][0] = values[0][0] * (lcm / values[0][1]) + values[k][0] * (lcm / values[k][1]);
            values[0][1] = lcm;
        }
        int gcd = GCD(Math.abs(values[0][0]), values[0][1]);
        values[0][0] /= gcd; values[0][1] /= gcd;
        return String.valueOf(values[0][0]) + "/" + String.valueOf(values[0][1]);
    }
    public int LCM(int num1, int num2) {
        return (num1 * num2) / GCD(num1, num2);
    }
    public int GCD(int a, int b) {
        if(b == 0) return a;
        else return GCD(b, a % b);
    }
}