package leetcodeMedium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LCNo451 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tree";
		System.out.println(frequencySort(s));

	}
	
	 public static String frequencySort(String s) {
		 if(s.length()==0) {
			 return s;
		 }
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 for(int i=0;i<s.length();i++) {
			 if(map.containsKey(s.charAt(i))) {
				 map.put(s.charAt(i), map.get(s.charAt(i))+1);
			 }else {
				 map.put(s.charAt(i), 1);
			 }
		 }
		 
		 PriorityQueue<Character> heap = new PriorityQueue<Character>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return map.get(o2)-map.get(o1);
			}

			
		});
		 
		 for(char ch:map.keySet()) {
			 heap.offer(ch);
		 }
		 
		 //List<Character> list = new ArrayList<Character>();
		 StringBuilder sb = new StringBuilder();
		 while(!heap.isEmpty()) {
			 char ch = heap.poll();
			 int n = map.get(ch);
			 for(int i=0;i<n;i++) {
				 sb.append(ch);
			 }
		 }
		 String res = sb.toString();
		 return res;
		 
		 
	 }

}
