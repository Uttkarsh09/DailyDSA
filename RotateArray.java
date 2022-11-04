// https://leetcode.com/problems/rotate-array/

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length, idx=0;
        int pivot = n - (k % n), i;
        int buff[] = new int[n - pivot];
        
        for(i=pivot ; i<n ; i++){
            buff[idx++] = nums[i];
        }
        
        i = n-1;
        for(idx=pivot-1 ; idx>=0 ; i--, idx--){
            nums[i] = nums[idx];
        }
        
        for(i=0 ; i<buff.length ; i++){
            nums[i] = buff[i];
        }
    }
}
