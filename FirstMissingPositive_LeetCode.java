// https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive_LeetCode {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {7,8,9,11,12};
        int[] arr2 = {3,4,-1,1};
        int ans = s.firstMissingPositive(arr1);
        System.out.println(ans);
        ans = s.firstMissingPositive(arr2);
        System.out.println(ans);
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, i=0;
        
        while(i<n){
            int target = nums[i];
            if(target>0 && target<n && target != nums[target-1]){
                swap(nums, i, target-1);
            } else {
                ++i;   
            }
        }

        for(i=0;i<n;i++){
            if(nums[i] != i+1) return i+1; 
        }
        
        return n+1;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}