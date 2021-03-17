package leetcodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LCNo39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates.length==0) {
			return res;
		}
		
		List<Integer> combination = new ArrayList<Integer>();
		dfs(candidates, 0, combination, target, res);
		return res;
	}
	
	public static void dfs(int[] candidates, int startIndex, List<Integer> combination, int remainTarget, List<List<Integer>> res) {
		//base case
		if(remainTarget < 0) {
			return;
		}
		
		if(remainTarget==0) {
			//here, it is very important, it needs the deep copy
			res.add(new ArrayList<Integer>(combination));
			return;
		}
		
		//go through all numbers in the candidate list
		for(int i = startIndex;i<candidates.length;i++) {
			combination.add(candidates[i]);
			dfs(candidates,i,combination,remainTarget-candidates[i],res);
			combination.remove(combination.size()-1);
		}
	}

}
