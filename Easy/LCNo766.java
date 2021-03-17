package leetcodeEasy;

public class LCNo766 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isToeplitzMatrix(int[][] matrix) {
		if(matrix.length==0) {
			return false;
		}
        int row = matrix.length;
        int column = matrix[0].length;
        if(row==1 || column==1) {
        	return true;
        }
        for(int i=1;i<row;i++) {
        	for(int j=1;j<column;j++) {
        		if(matrix[i][j]!=matrix[i-1][j-1]) {
        			return false;
        		}
        	}
        }
        return true;
    }

}
