// https://leetcode.com/problems/product-of-array-except-self/

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, preSum=1, postSum=1;
        int prefix[] = new int[n];
        int postfix[] = new int[n];
        
        for(int i=0 ; i<n ; i++){
            prefix[i] = preSum;
            postfix[n-i-1] = postSum;
            preSum *= nums[i];
            postSum *= nums[n-i-1];
        }
        
        for(int i=0 ; i<n ; i++){
            nums[i] = prefix[i] * postfix[i];
        }
        
        return nums;
    }
}
