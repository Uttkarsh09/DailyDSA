// https://leetcode.com/problems/3sum/submissions/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

class ThreeSum {
    boolean binarySearch(int[] nums, int target, int start, int end){
        int mid;
        while(start<=end){
            mid = (start + end) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid]<target) start=mid+1;
            else end = mid-1;
        }
        
        return false;
    }
    
    // MY SOLUTION - VERY SLOW BUT DOES THE JOB (1854 ms)
    public List<List<Integer>> threeSumSolution1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        int len = nums.length, sum=0, i, j, remaining;
        String s;
        
        for(i=0 ; i<len ; i++){
            for(j=i+1 ; j<len ; j++){
                sum = nums[i] + nums[j];
                remaining = 0 - sum;
                if(binarySearch(nums, remaining, j+1, len-1)){
                    List<Integer> temp = new ArrayList<>();
                    s = "" + nums[i] + "" + nums[j] + "" + remaining;
                    if(!hs.contains(s)){
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(remaining);
                        ans.add(temp);
                        hs.add(s);
                    }
                }
            }
        }
        
        return ans;
    }
    
    // Solution from - https://leetcode.com/problems/3sum/discuss/7402/Share-my-AC-C%2B%2B-solution-around-50ms-O(N*N)-with-explanation-and-comments (29ms)
    public List<List<Integer>> threeSumSolution2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length, remaining, front, back, sum;
        
        for(int i=0 ; i<len ; i++){
            remaining = -nums[i];
            front = i+1;
            back = len-1;
            
            while(front < back){
                sum = nums[front] + nums[back];
                if(sum < remaining){
                    front++;
                } 
                else if(sum > remaining){
                    back--;
                }
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[front]);
                    temp.add(nums[back]);
                    ans.add(temp);
                    
                    while((front < back) && (nums[front] == temp.get(1))){
                        ++front;
                    }
                    while((front < back) && (nums[back] == temp.get(2))){
                        --back;
                    }
                }
            }
            while(i+1 < len && nums[i+1] == nums[i]){
                ++i;
            }
        }
        
        return ans;
    }    
}