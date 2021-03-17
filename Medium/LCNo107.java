package leetcodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCNo107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> ZigZagTravsal(TreeNode root){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(root==null) {
			return list;
		}
		
		q.offer(root);
		boolean isLeft = true;
		while(!q.isEmpty()) {
			List<Integer> res = new ArrayList<Integer>();
			int size = q.size();
			for(int i=0;i<size;i++) {
				TreeNode temp = q.poll();
				if(temp.left!=null) {
					q.offer(temp.left);
				}
				if(temp.right!=null) {
					q.offer(temp.right);
				}
				if(isLeft) {
					res.add(temp.val);
				}else {
					res.add(0,temp.val);
				}
			}
			isLeft = !isLeft;
			list.add(res);
		}
		return list;
		
	}

}
