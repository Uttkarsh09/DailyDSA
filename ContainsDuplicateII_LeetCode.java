// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.ArrayList;
import java.util.HashMap;

public class ContainsDuplicateII_LeetCode {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(s.containsNearbyDuplicate(nums, k));
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int currElement = nums[i];
            if(hm.containsKey(currElement)){
                if(Math.abs(i - hm.get(currElement)) <= k){
                    return true;
                }
            }
            hm.put(currElement, i);
        }
        
        return false;
    }
}