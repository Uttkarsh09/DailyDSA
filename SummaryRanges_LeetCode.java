class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        int startNum, endNum, n=nums.length, curr, prev;
        List<String> ans = new ArrayList<>();
        
        if(n == 0) return ans;
        
        startNum = nums[0];
        for(int i=1 ; i<n ; i++){
            curr = nums[i];
            prev = nums[i-1];
            
            if(Math.abs(curr - prev) > 1){
                endNum = prev;
                if(startNum == endNum){
                    ans.add(startNum+"");
                }
                else {
                    ans.add(startNum+"->"+endNum);   
                }
                startNum = curr;
            }
        }
        
        endNum = nums[n-1];
        if(startNum == endNum){
            ans.add(endNum+"");
        } 
        else {
            ans.add(startNum+"->"+endNum);
        }
        
        return ans;
    }
}