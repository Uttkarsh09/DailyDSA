// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


public class FirstAndLastPosition_LeetCode {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] ans = s.searchRange(nums, target);

        System.out.print("[");
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]);
            System.out.print(i!=ans.length-1 ? ", " : "");
        }
        System.out.println("]");
    }
}

class Solution {
    private int binarySearch(int[] nums, int target){
        int start=0, end=nums.length-1, mid;
        
        while(start<=end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            } else if (target < nums[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[] {n-1, n-1};
        if(n == 1 && nums[0]==target) return new int[] {0, 0};      
        if(n == 1 && nums[0]!=target) return new int[]{-1, -1};
        
        int tempIndex = binarySearch(nums, target);
        if(tempIndex == -1) return new int[] {-1, -1};
        int firstIdx=tempIndex, lastIdx=tempIndex;
        
        while(firstIdx > 0 && nums[firstIdx] == nums[firstIdx-1]){
            --firstIdx;
        }
        
        while(lastIdx < n-1 && nums[lastIdx] == nums[lastIdx+1]){
            ++lastIdx;
        }
        return new int[]{firstIdx, lastIdx};
    }
}







