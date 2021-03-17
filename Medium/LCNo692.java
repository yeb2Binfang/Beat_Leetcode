package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LCNo692 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "b";
		String s2 = "aab";
		System.out.println(s1.compareTo(s2));
		String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 1;
		System.out.println(topKFrequent(words, k));

	}
	
	public static List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<String> heap = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int value1 = map.get(o1);
                int value2 = map.get(o2);
                if (value1 == value2) {
                	//System.out.println(o1.compareTo(o2));
                    return o2.compareTo(o1);
                }
                return value1 - value2;
			}
		});
		
		for(String s : words) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		
		for(String s : map.keySet()) {
			heap.offer(s);
			if(heap.size()>k) {
				heap.poll();
			}
			
		}
		
		while(heap.size()!=0) {
			res.add(heap.poll());
		}
		
		Collections.reverse(res);
		return  res;
    }
	

}
