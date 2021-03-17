package leetcodeMedium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCNo216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();

	}
	
	public static List<List<Integer>> combinationSumIII(int k, int n){
		int[] candidates = {1,2,3,4,5,6,7,8,9};
		List<Integer> combination = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(k>n) {
			return res;
		}
		dfs(candidates, 0, n, k, combination, res);
		return res;
	}
	
	public static void dfs(int[] candidates, 
						   int startIndex, 
						   int remainTarget, 
						   int k, 
						   List<Integer> combination, 
						   List<List<Integer>> res ) {
		
		if(remainTarget==0 && combination.size()==k) {	
				res.add(new ArrayList<Integer>(combination));
				return;
			
		}
		
		for(int i=startIndex;i<candidates.length;i++) {
			if(remainTarget<0 || combination.size()>k){
				if(i>startIndex && combination.get(i)==combination.get(i-1)) {
					break;
				}
				break;
			}
			
			combination.add(candidates[i]);
			dfs(candidates,i+1,remainTarget-candidates[i],k,combination,res);
			combination.remove(combination.size()-1);
		}
	}

}
