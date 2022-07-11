// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import java.util.HashMap;

class Solution {

    public int[] method1(int[] numbers, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = numbers.length, i, required;
        
        for(i=0;i<n;i++){
            required = target - numbers[i];
            if(hm.containsKey(required)){
                return new int[]{hm.get(required)+1, i+1};
            } else {
                hm.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    // THIS IS A SIMPLER AND FASTER SOLUTION
    public int[] fasterMethod(int[] numbers, int target){
        int start=0, end=numbers.length-1;
        
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target) return new int[]{start+1, end+1};
            else if(sum < target) ++start;
            else --end;
        }
        
        return new int[]{};
    }

    public int[] twoSum(int[] numbers, int target) {
        return fasterMethod(numbers, target);
    }
}

class TwoSumII_LeetCode{
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {2,7,11,15};
        int target = 9;

        int[] ans = s.twoSum(arr, target);
        
        System.out.print("[");
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]);
            System.out.print(i!=ans.length-1 ? ", " : "");
        }
        System.out.println("]");
    }
}