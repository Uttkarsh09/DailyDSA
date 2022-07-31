// https://leetcode.com/problems/isomorphic-strings/solution/
import java.util.HashMap;

public class IsomorphicStrings_LeetCode {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "add";
        String t = "egg";
        boolean ans = sol.isIsomorphic_fast(s, t);
        System.out.println(ans);
    }
}

class Solution {
    // O(2n) -> O(n)
    // FASTER
    public boolean isIsomorphic_fast(String s, String t){
        HashMap<String, String> hm_s_t = new HashMap<>();
        HashMap<String, String> hm_t_s = new HashMap<>();
        
        if(s.length() != t.length()) return false;

        for(int i=0;i<s.length();i++){
            String sCh = s.charAt(i)+"";
            String tCh = t.charAt(i)+"";

            if(!hm_s_t.containsKey(sCh)) hm_s_t.put(sCh, tCh);
            if(!hm_t_s.containsKey(tCh)) hm_t_s.put(tCh, sCh);
        }

        String newS="", newT="";
        for(int i=0;i<s.length();i++){
            String sCh = s.charAt(i)+"";
            String tCh = t.charAt(i)+"";
            newS += hm_s_t.get(sCh)+"";
            newT += hm_t_s.get(tCh)+"";
        }
        // System.out.println(hm_s_t);
        // System.out.println(hm_t_s);
        
        // System.out.println(newS + " " + t);
        // System.out.println(newT + " " + s);

        if((!newS.equals(t)) || (!newT.equals(s))){
            return false;
        }
        
        return true;
    }

    // SLOWER
    public boolean isIsomorphic_slow(String s, String t) {
        HashMap<String, String> hm = new HashMap<>();
        
        if(s.length() != t.length()){
            return false;
        }
        
        for(int i=0;i<s.length();i++){
            String sCh = s.charAt(i) + "";
            String tCh = t.charAt(i) + "";
            if(hm.containsKey(sCh)){
                if(!hm.get(sCh).equals(tCh)) return false;
            } else {
                hm.put(sCh, tCh);
                for(String key:hm.keySet()){
                    // prevent checking the current added one
                    if(!key.equals(sCh)){
                        // if the newly added character's value and some already existing key's value is same return false.
                        // As it proves to keys are mapped to the same value.
                        if(hm.get(key).equals(hm.get(sCh))) return false;
                    }
                }
            }
        }
        return true;
    }

    
}