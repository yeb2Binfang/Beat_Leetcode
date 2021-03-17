package leetcodeMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class LCN0347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{4,1,-1,2,-1,2,3};
		int k = 2;
		System.out.println(Arrays.toString(topKFrequent(nums, k)));

	}
	
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num,1);
			}
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o1)-map.get(o2);
			}
		});
		
		for(Integer key : map.keySet()) {
			if(heap.size()<k) {
				heap.add(key);
			}else if(map.get(key)>map.get(heap.peek())) {
				heap.remove();
				heap.add(key);
			}
		}
		
		int[] res = new int[k];
		for(int i=0;i<k;i++) {
			res[i]=heap.poll();
		}
		return res;
		
    }

}
