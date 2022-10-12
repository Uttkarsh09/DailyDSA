// https://leetcode.com/problems/search-a-2d-matrix-ii/

public class SearchA2DMatrixII_LeetCode {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}};
        int target = 22;

        SomeSolution s = new SomeSolution();
        EfficientSolution es = new EfficientSolution();
        
        System.out.println(es.searchMatrix(matrix, target));
        System.out.println(s.searchMatrix(matrix, target));
    }
}

class EfficientSolution {
    public boolean searchMatrix(int[][] matrix, int target){
        int column = matrix[0].length-1, row = 0;
        int element;

        while((column >= 0) && (row <= matrix.length-1)){
            element = matrix[row][column];

            if(element == target){
                return true;
            }
            else if (element < target){
                ++row;
            } else {
                --column;
            }
        }
        return false;
    }
}

class SomeSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1, n = matrix[0].length-1;
        if(target < matrix[0][0]) return false;
        
        while(matrix[m][0] > target) --m;
        while(matrix[0][n] > target) --n;
        
        int start, end, mid, i;
        for(i=0;i<=m;i++){
            start = 0;
            end = n;
            while(start <= end){
                mid = start + (end - start)/2;
                if(matrix[i][mid] == target) return true;
                if(target < matrix[i][mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return false;        
    }
}