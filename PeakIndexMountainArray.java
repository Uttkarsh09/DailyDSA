// https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class PeakIndexMountainArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {0,10,5,2};
        int ans = s.peakIndexInMountainArray(arr);
        System.out.println(ans);
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0, end=arr.length-1, mid;
        
        while(start<=end){
            mid = start + (end - start) / 2;
            int leftPeak = arr[mid - 1];
            int targetPeak = arr[mid];
            int rightPeak = arr[mid + 1];
            
            if((leftPeak < targetPeak) && (targetPeak > rightPeak)) return mid;
            
            if(leftPeak > targetPeak){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return -1;
    }
}