// 

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int i=0, j=nums.length-1;
        int ans[] = new int[nums.length];
        
        for(int m=j ; m>=0 ; m--){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                ans[m] = (int)Math.pow(nums[i++], 2);
            } else {
                ans[m] = (int)Math.pow(nums[j--], 2);
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int nums[] = {-4, -1, 0, 3, 10};
        nums = sortedSquares(nums);
        
        for(int i=0 ; i<nums.length ; i++){
            System.out.print(nums[i] + " ");
        }System.out.println();
    }
}
