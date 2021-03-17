package leetcodeEasy;

public class LCNo198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] house = {2,7,9,3,1};
		LCNo198 houserub = new LCNo198();
		//System.out.println(houserub.houseRubber(house));
		System.out.println(houserub.houseRubberSlidingArr(house));

	}
	
	public int houseRubber(int[] A) {
		if(A.length==0) {
			return 0;
		}
		
		int[] result = new int[A.length+1];
		
		result[0] =0;
		result[1] = A[0];
		for(int i=2;i<=A.length;i++) {
			result[i] = Math.max(result[i-1], A[i-1]+result[i-2]);
		}
		return result[A.length];
		
	}
	
	public int houseRubberSlidingArr(int[] A) {
		if(A.length==0){
			return 0;
		}
		if(A.length==1) {
			return A[0];
		}
		
		
		int p = A[0];
		int q = Math.max(A[0], A[1]);
		for(int i=2;i<A.length;i++) {
			int temp=q;
			q=Math.max(A[i]+p, q);
			p=temp;
		}
		return q;
		
		
		
	}

}
