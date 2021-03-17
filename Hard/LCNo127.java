package leetcodeHard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LCNo127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		int step = ladderLength(beginWord, endWord, wordList);
		System.out.println(step);

	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> wordSet = new HashSet<String>(wordList);
       if(wordSet.size()==0 || !wordSet.contains(endWord)) {
    	   return 0;
       }
       
       wordSet.remove(beginWord);
       
       Queue<String> queue = new LinkedList<String>();
       queue.offer(beginWord);
       Queue<String> visited = new LinkedList<String>();
       visited.offer(beginWord);
       
       int step=1;
       while(!queue.isEmpty()) {
    	   int currentSize = queue.size();
    	   for(int i=0;i<currentSize;i++) {
    		   String currentWord = queue.poll();
    		   if(changeWord(currentWord, endWord, queue, visited, wordSet)) {
    			   return step+1;
    		   }
    	   }
    	   step++;
       }
       return 0;
    }
	
	public static boolean changeWord(String currentWord, String endWord, Queue<String> queue, Queue<String> visited, Set<String> wordSet) {
		char[] ch = currentWord.toCharArray();
		for(int i=0;i<ch.length;i++) {
			char originalLetter = ch[i];
			for(char k='a';k<='z';k++) {
				if(originalLetter==k) {
					continue;
				}
				ch[i] = k;
				String nextWord = String.valueOf(ch);
				if(wordSet.contains(nextWord)) {
					if(nextWord.equals(endWord)) {
						return true;
					}
					if(!visited.contains(nextWord)) {
						queue.add(nextWord);
						visited.add(nextWord);
					}
				}
			}
			ch[i]=originalLetter;
		}
		return false;
	}


    
}
