// https://leetcode.com/problems/spiral-matrix/
import java.util.ArrayList;

class SpiralMatrix{
    public static void main(String[] args) {
        int arr1[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int arr2[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(arr1));
        System.out.println(spiralOrder(arr2));

    }

    public static void printAns(java.util.ArrayList<Integer> ans, int idx){
        System.out.print("[");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + ", ");
        }System.out.println("] -> " + idx);
    }
    
    public static java.util.List<Integer> spiralOrder(int[][] matrix) {
        int colLength = matrix.length-1;
        int rowLength = matrix[0].length-1;
        java.util.ArrayList<Integer> ans = new ArrayList<>();
        int idx = 0;
        int startRowIdx1=0, startRowIdx2=rowLength, topRowCount=0;
        int endRowIdx1=rowLength, endRowIdx2=0, bottomRowCount=colLength;
        int leftColIdx1=colLength-1, leftColIdx2=1, leftColCount=0;
        int rightColIdx1=1, rightColIdx2=colLength-1, rightColCount=rowLength;
        
        while(idx <= (matrix.length * matrix[0].length)){
            for(int i=startRowIdx1 ; i<=startRowIdx2 ; i++){
                ans.add(matrix[topRowCount][i]);
                ++idx;
            }
            ++topRowCount;
            ++startRowIdx1;
            --startRowIdx2;
            // printAns(ans, idx);
            if(idx >= (matrix.length * matrix[0].length)) break;
            
            for(int i=rightColIdx1 ; i<=rightColIdx2 ; i++){
                ans.add(matrix[i][rightColCount]);
                ++idx;
            }
            --rightColCount;
            ++rightColIdx1;
            --rightColIdx2;            
            // printAns(ans, idx);
            
            for(int i=endRowIdx1 ; i>=endRowIdx2 ; i--){
                ans.add(matrix[bottomRowCount][i]);
                ++idx;
            }
            --bottomRowCount;
            --endRowIdx1;
            ++endRowIdx2;
            // printAns(ans, idx);
            if(idx >= (matrix.length * matrix[0].length)) break;
            
            for(int i=leftColIdx1 ; i>=leftColIdx2 ; i--){
                ans.add(matrix[i][leftColCount]);
                ++idx;
            }
            ++leftColCount;
            --leftColIdx1;
            ++leftColIdx2;
            // printAns(ans, idx);
        }
        
        return ans;
    }
}