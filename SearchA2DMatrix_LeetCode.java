// https://leetcode.com/problems/search-a-2d-matrix/

public class SearchA2DMatrix_LeetCode {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 10;

        Solution s = new Solution();
        System.out.println(s.searchMatrix(matrix, target));
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length-1;
        
        for(int i=0;i<matrix.length;i++){
            if(target <= matrix[i][n]){
                int start = 0, end = n, mid;
                while(start<=end){
                    mid = start+(end-start)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    } 
                    if(target < matrix[i][mid]){
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                return false;
            }
        }
        
        return false;
    }
}
