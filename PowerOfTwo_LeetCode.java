// https://leetcode.com/problems/power-of-two/

public class PowerOfTwo_LeetCode {
    public static void main(String[] args) {
        int n = 1024;
        boolean ans = isPowerOfTwo(n);
        System.out.println(ans);
    }

// Let's take some good exampes :
// number->binary form
// 3->0000 0011
// 4->0000 0100
// 5->0000 0101
// 6->0000 0110
// 7->0000 0111
// 8->0000 1000
// The observation we can conclude is that the number which is a power of two has always compulsoryily 1 true bit.
// Now consider :-
// bit representation of 7  -> 0111
// bit representation of 8  -> 1000
// bitwise AND of 7 and 8 -> 0111 & 1000 => 0000
// we are gonna use this property for for all numbers which are powers of two
// Reference - https://leetcode.com/problems/power-of-two/discuss/1638704/C%2B%2B-EASY-TO-SOLVE-oror-All-INTERVIEW-APPROACHES-with-Detailed-Explanations

    public static boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n & (n-1)) == 0;
    }
}