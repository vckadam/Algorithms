/*
537. Complex Number Multiplication
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
*/
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] num1 = getComplexNumber(a);
        int[] num2 = getComplexNumber(b);
        int realPart = num1[0]*num2[0] - num1[1]*num2[1];
        int imgPart = num1[0]*num2[1] + num1[1]*num2[0];
        System.out.println(realPart+":"+imgPart);
        return convertToComplex(realPart,imgPart);
    }
    public int[] getComplexNumber(String str) {
        String[] strA = str.split("\\+");
        int[] ret = new int[2];
        ret[0] = Integer.parseInt(strA[0]);
        ret[1] = (strA[1].charAt(0)=='-')?Integer.parseInt(strA[1].substring(1,strA[1].length()-1)):Integer.parseInt(strA[1].substring(0,strA[1].length()-1));
        System.out.println(Arrays.toString(ret));
        return ret;
    }
    public String convertToComplex(int realPart, int imgPart) {
        return String.valueOf(realPart)+"+"+String.valueOf(imgPart)+"i";
    }
}