package leetcodeMedium;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;





public class LCNo102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 3, 5, 6, 6, 6, 6 }; 
		TreeNode root = new TreeNode(-1);
		root = addTreeNode(arr, root, 0);
		
		//inOrder(root);
//		dfs(root);
		//bfs(root);
	
		
	
        

	}
	
	public static TreeNode addTreeNode(int[] arr, TreeNode root, int i) {
		if(i<arr.length) {
			TreeNode temp = new TreeNode(arr[i]);
			root = temp;
			
			root.left = addTreeNode(arr, root.left, 2*i+1);
			root.right = addTreeNode(arr, root.right, 2*i+2);
			
		}
		return root;
	}
	
	 public static void inOrder(TreeNode root) 
	 { 
	     if (root != null) { 
	        	
	         inOrder(root.left); 
             System.out.print(root.val + " ");  
             inOrder(root.right); 
	     } 
	 }
	 
	 public static void dfs(TreeNode root) {
		 if(root==null) {
			 return;
		 }
		 
		 System.out.println(root.val);
		 dfs(root.left);
		 dfs(root.right);
		 
	 }
	 
	 public static void bfs(TreeNode root) {
		 if(root==null) {
			 return;
		 }
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.println(temp);
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}

	 }
	 
	 public static List<List<Integer>> BinaryTreeLevelOrderTraversal(TreeNode root){
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 if(root==null) {
			 return res;
		 }
		 
		 
		 
		 Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		 q.add(root);
		 while(!q.isEmpty()) {
			 
			 List<Integer> travsal = new ArrayList<Integer>();
			 int size = q.size();
			 for(int i=0;i<size;i++) {
				 TreeNode temp = q.poll();
				 travsal.add(temp.val);
				 if(temp.left!=null) {
					 q.add(temp.left);
				 }
				 
				 if(temp.right!=null) {
					 q.add(temp.right);
				 }
			 }
			 res.add(travsal);
			 
		 }
		 return res;
	 }


}
