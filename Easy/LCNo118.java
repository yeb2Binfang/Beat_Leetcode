package leetcodeEasy;

import java.util.ArrayList;
import java.util.List;

public class LCNo118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pascalTriancle(10));
		System.out.println(pascalTriancleII(1));

	}
	
	public static List<List<Integer>> pascalTriancle(int numrow) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0;i<numrow;i++) {
			List<Integer> row = new ArrayList<Integer>();
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i) {
					row.add(1);
				}else {
					row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
				}
			}
			result.add(row);
		}
		return result;
	}
	
	public static List<Integer> pascalTriancleII(int rowIndex){
		List<List<Integer>> result = pascalTriancle(rowIndex+1);
		return result.get(rowIndex);
	}
	
	public static List<Integer> pascalTriangleIIMethod2(int rowIndex){
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		for(int i=0;i<rowIndex;i++) {
			for(int j=i;j>=1;j--) {
				res.set(j, res.get(j-1)+res.get(j));
			}
			res.add(1);
		}
		return res;
	}

}
