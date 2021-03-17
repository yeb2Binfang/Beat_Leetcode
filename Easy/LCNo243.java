package leetcodeEasy;

public class LCNo243 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "coding";
		
		System.out.println(shortestWordDistance(words, word1, word2));

	}
	
	public static int shortestWordDistance(String[] words, String word1, String word2) {
		
		int m=0;
		int n=words.length;
		int dis = Integer.MAX_VALUE;
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(word1)) {
				m=i;
			}
			
			if(words[i].equals(word2)) {
				n=i;
			}
			
			dis = Math.min(dis, Math.abs(m-n));
			
		}
		
		return dis;
		
	}

}
