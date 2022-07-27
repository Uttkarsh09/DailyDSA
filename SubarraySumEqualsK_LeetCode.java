import java.util.HashMap;

public class SubarraySumEqualsK_LeetCode {
    public static void main(String[] args){
        Solution s = new Solution();
        int ans = s.subarraySum_hashMap(new int[]{1, 1, 1}, 2);
        System.out.println(ans);

        System.out.println("~~~~~~~~~~~~~~~");

        ans = s.subarraySum_hashMap(new int[]{1, -1, 0}, 0);
        System.out.println(ans);
    }
}

// The idea here is to have a new array having first index as 0 and then the sum of all the elements in nums.
// Why is the first element 0?
//      So because if we have k=7 and first element as k then that will be a sub array with 1 element. eg [7, 2, 3, 4] -> [7] & [3, 4] are the 2 sub arrays for this.
//      Hence we make a new array having [0, 7, 9, 12, 16]. so if we subtract elements at 2 indices (greater minus less) and if the result is 7 then we can confirm that it is a subarray.
//      So for example here 0-7 and 16-9 these tell us that those elements add upto 7.

class Solution {
    public int subarraySum_bruteForce(int[] nums, int k) {
        // In this brute force solution we create every possible array and then subtract the greater index from the lower index and then check whether the result is k or not.
        // if it is k then we increase the count and move on and return it in the end.
        int count=0;
        int[] sum = new int[nums.length+1];
        
        sum[0] = 0;
        for(int i=1;i<=nums.length;i++){
            sum[i] = sum[i-1] + nums[i - 1];
        }
        
        for(int start=0;start<=nums.length;start++){
            for(int end=start+1;end<=nums.length;end++){
                if(sum[end] - sum[start] == k){
                    ++count;
                }
            }
        }
        
        return count;
    }

// [1, -1, 0]           {0=2, 1=1, }
// i = 2
// sum = 0
// count = 1

    public int subarraySum_hashMap(int[] nums, int k){
        // The only and major difference here is that we are using a hash map to check whether we had an element in the sum array that is [sum till now] - k.
        // And store the occourace count in the value of that key.cl
        
        int count = 0, sum=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hm.containsKey(sum-k)) count += hm.get(sum-k);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            System.out.println("sum = " + sum);
            System.out.println("hm = " + hm);
        }

        return count;
    }
}
