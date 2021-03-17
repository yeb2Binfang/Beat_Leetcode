package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LCNo373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[]{1,7,11};
		int[] nums2 = new int[]{2,4,6};
		int k = 3;
		System.out.println(kSmallestPairs(nums1, nums2, k));

	}
	
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();
        
        if (n1 == 0 || n2 == 0 || k == 0) return result;
        for (int i = 0; i < n1; i++) {
        	//System.out.println(Arrays.toString(new int[] {i,0}));
        	pq.offer(new int[]{i, 0});
        }
        	

        while(pq.size() > 0 && k > 0) {
        	int[] pair = pq.poll();
        	//System.out.println(Arrays.toString(pair));
        	if (pair[1] + 1 < n2) {
        		System.out.println(pair[0]);
        		System.out.println(pair[1]);
        		pq.offer(new int[]{pair[0], pair[1]+1});
        	}
        	List<Integer> temp = new ArrayList<>();
        	temp.add(nums1[pair[0]]);
        	temp.add(nums2[pair[1]]);
        	result.add(temp);
                k--;
        }

        return result;
    }



}
