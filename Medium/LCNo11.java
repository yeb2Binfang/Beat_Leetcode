package leetcodeMedium;
/*
 * Given n non-negative integers a1, a2, ..., an , 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn 
 * such that the two end points of the line i is at (i, ai) and (i, 0). Find two lines, which, 
 * together with the x-axis forms a container, such that the container contains the most water.

 * 
 * */

public class LCNo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,2,1,4};
		//System.out.println(MaxAreaBruteForce(arr));
		System.out.println(MaxAreaTwoPointers(arr));
	}
	
	public static int MaxAreaBruteForce(int[] arr) {
		int max = 0;
		int area =0;
		int min = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				min = (arr[i]>=arr[j]) ? arr[j] : arr[i];
				area = (j-i) * min;
				max = (area>=max)? area : max;
			}
		}
		
		return max;
	}
	
	public static int MaxAreaTwoPointers(int[] arr) {
		int i = 0;
		int j = arr.length-1;
		int area =0;
		int min = 0;
		
		
		while(i<j) {
			
			min = Math.min(arr[j], arr[i]);
			area = (area > (j-i)*min) ? area : ((j-i)*min);
			
			if(arr[i]>=arr[j]) {
				j--;
			}else {
				i++;
			}
		}
		
		
		return area;
	}

}
