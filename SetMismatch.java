// https://leetcode.com/problems/set-mismatch/

class SetMismatch{
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2,4};
        int ans[] = findErrorNums(arr);
        
        System.out.print("[");
        for(int i=0 ; i<ans.length ; i++){
            System.out.print(ans[i]);
            if(i!=ans.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int ans[] = new int[len];
        int repeat = -1;
        
        for(int i=0 ; i<len ; i++){
            ans[i]=-1;
        }
        
        for(int i=0 ; i<len ; i++){
            if(ans[nums[i]-1] != -1){
                repeat = nums[i];
            }
            ans[nums[i]-1] = nums[i];
        }
        
        for(int i=0 ; i<len ; i++){
            if(ans[i] == -1) return new int[]{repeat, i+1};
        }
        
        return new int[]{-1, -1};
    }
}