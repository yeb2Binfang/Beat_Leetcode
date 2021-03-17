package leetcodeHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class LCNo51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		initBoard(board);
		dfs(board,0,res);
		return res;
	}
	
	public static char[][] initBoard(char[][] board){
		for(char[] row : board) {
			Arrays.fill(row, '.');
		}
		return board;
	}
	
	public static void dfs(char[][] board, int rowIndex,List<List<String>> res) {
		if(rowIndex==board.length) {
			res.add(generate(board));
			return;
		}
		
		for(int colIndex=0;colIndex<board.length;colIndex++) {
			if(isValid(board, rowIndex, colIndex)) {
				board[rowIndex][colIndex]='Q';
				dfs(board, rowIndex+1, res);
				board[rowIndex][colIndex]='.';
			}
		}
	}
	
	
	public static boolean isValid(char[][] board, int rowIndex, int colIndex) {
		//check row
		for(int i=0;i<=rowIndex;i++) {
			if(board[i][colIndex]=='Q') {
				return false;
			}
		}
		
		//check col
		for(int j=0;j<=colIndex;j++) {
			if(board[rowIndex][j]=='Q') {
				return false;
			}
		}
		
		//check left diag
		for(int i=rowIndex-1,j=colIndex-1;i>=0 && j>=0;i--,j--) {
			if(board[i][j]=='Q') {
				return false;
			}
		}
		
		//check right diag
		for(int i=rowIndex,j=colIndex;i>=0&&j<board.length;i--,j++) {
			if(board[i][j]=='Q') {
				return false;
			}
		}
		return true;
	}
	
	public static List<String> generate(char[][] board){
		List<String> list = new ArrayList<String>();
		for(char[] row : board) {
			StringBuilder sb = new StringBuilder();
			for(char c: row) {
				sb.append(c);
			}
			list.add(sb.toString());
		}
		return list;
	}
	


}
