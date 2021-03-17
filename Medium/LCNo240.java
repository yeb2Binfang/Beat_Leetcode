package leetcodeMedium;

public class LCNo240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		//System.out.println(Search2DMatrixBruteForce(matrix, 20));
		System.out.println(Search2DMatrixNarrowRange(matrix, 20));

	}
	
	public static boolean Search2DMatrixBruteForce(int[][] matrix, int target) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]==target) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean Search2DMatrixNarrowRange(int[][] matrix, int target) {
		
		int row = matrix.length-1;
		int col = 0;
		while(row>=0 && col<matrix[0].length) {
			if(matrix[row][col]==target) {
				return true;
			}else if(matrix[row][col]>target) {
				row--;
			}else {
				col++;
			}
		}
		return false;
	}
}
