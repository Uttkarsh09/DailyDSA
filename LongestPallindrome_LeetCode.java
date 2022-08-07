// https://leetcode.com/problems/longest-palindrome/
import java.util.HashMap;

public class LongestPallindrome_LeetCode {
    public static void main(String[] args) {
        String test = "abccccdd";
        Solution s = new Solution();
        int ans = s.longestPalindrome(test);
        System.out.println(ans);
    }
}

class Solution {
    public int longestPalindrome(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        int count=0, most_odd_occurance=0, curr_char_count, flag=0;
        String curr_char;
        
        for(int i=0;i<s.length();i++){
            curr_char = s.charAt(i)+"";
            
            if(hm.containsKey(curr_char)){
                curr_char_count = hm.get(curr_char);
                hm.put(curr_char, ++curr_char_count);            
            } else {
                hm.put(curr_char, 1);
            }
        }
        
        for(String ch:hm.keySet()){
            curr_char_count = hm.get(ch);
            if((curr_char_count % 2) == 0){
                count += curr_char_count;
            } else {
                count += Math.max(curr_char_count-1, 0);
                flag = 1;
            }
        }
        
        return count + flag;
    }
}