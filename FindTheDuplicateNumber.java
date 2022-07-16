public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3,1,3,4,2};
        int ans = s.findDuplicate(arr);
        System.out.println(ans);
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int i=0, n=nums.length;
        
        while(i < n){
            int target = nums[i];
            if(target != nums[target-1]){
                swap(nums, i, target-1);
            } else {
                ++i;   
            }
        }
        
        for(i=0;i<n;i++){
            if(nums[i] != i+1) return nums[i];
        }
        
        return -1;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}