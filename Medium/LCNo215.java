package leetcodeMedium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LCNo215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		return nums[n-k];
    }
	
	public int findKthLargestQueue(int[] nums, int k) {
		PriorityQueue<Integer> pqNums = new PriorityQueue<Integer>();
		int n = nums.length;
		for(int i=0;i<n;i++) {
			pqNums.offer(nums[i]);
			if(pqNums.size()>k) {
				pqNums.poll();
			}
		}
		return pqNums.peek();
	}

}
