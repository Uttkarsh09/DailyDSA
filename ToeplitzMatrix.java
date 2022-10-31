// https://leetcode.com/problems/toeplitz-matrix/

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {        
        if(matrix.length == 1) return true;
        int i, j, c;
        
        for(c=matrix.length-2 ; c>=0 ; c--){
            i = c;
            j = 0;
            while(i<=matrix.length-2 && j<=matrix[0].length-2){
                if(matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
                ++i;
                ++j;
            }
        }
        
        for(c=1 ; c<=matrix[0].length-1 ; c++){
            i = 0;
            j = c;
            while(i<=matrix.length-2 && j<=matrix[0].length-2){
                if(matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
                ++i;
                ++j;
            }
        }
            
        
        return true;
    }
}
