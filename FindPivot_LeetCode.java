// https://leetcode.com/problems/find-pivot-index/

public class FindPivot_LeetCode {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int ans = pivotIndex(nums);
        System.out.println(ans);
    }
    
    public static int pivotIndex(int[] nums) {
        int n=nums.length, lSum=0, sum=0;
        for(int i:nums) sum += i;
        
        for(int i=0;i<n;i++){
            if(lSum == sum-(lSum+nums[i])){
                return i;
            }
            lSum += nums[i];
        }
        return -1;
    }
}