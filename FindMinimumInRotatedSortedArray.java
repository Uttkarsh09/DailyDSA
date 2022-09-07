// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length-1;
        int start=0, mid, end=n;
        
        while(start < end){
            mid = start + (end - start)/2;
            
            if((mid != n) && (nums[mid] > nums[mid+1])){
                return nums[mid+1];
            }
            else if((mid != 0) && (nums[mid] < nums[mid-1])){
                return nums[mid];
            }
            
            if(nums[start] > nums[mid]){
                end = mid - 1;
            } 
            else {
                start = mid + 1;    
            }
        }
        
        return nums[0];
    }
}
