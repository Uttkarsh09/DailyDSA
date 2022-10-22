// https://leetcode.com/problems/jump-game/

public class JumpGame {
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        int arr1[] = {3,2,1,0,4};
        System.out.println(canJump(arr));
        System.out.println(canJump(arr1));        
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len==1) return true;
        int currIdx = 0, tempIdx, max, i;
        
        while(nums[currIdx] != 0){
            tempIdx=currIdx+1;
            max=-1;
            
            for(i=currIdx+1 ; i <= currIdx+nums[currIdx] ; i++){
                if(i+nums[i] >= len-1) return true;
                if(nums[i]!=0 && nums[i]+i >= max){
                    max = nums[i]+i;
                    tempIdx = i;
                }
            }
            currIdx = tempIdx;
        }
        
        return false;
    }
}
