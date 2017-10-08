/*
693. Binary Number with Alternating Bits

Given a positive integer, check whether it has alternating bits or not.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111

*/

class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        if(n == 0)
            return false;
        int last = (n & 1);
        for(int i = 1; i < 32 && (n>>i) != 0; i++) {
            if(last == ((n >> i)&1))
                return false;
            last = ((n >> i) & 1);
        }
        return true;
    }
}
