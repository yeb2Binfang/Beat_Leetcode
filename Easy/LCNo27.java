package leetcodeEasy;

public class LCNo27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,3,4,5,6,6,7};
		System.out.println(removeElement(arr, 6));
	}
	
	public static int removeElement(int[] arr, int val) {
		
		int i =0;
		for(int j = 0;j<arr.length;j++) {
			if(arr[j]!= val) {
				arr[i] = arr[j];
				i++;
			}
		}
		
		return i;
	}
	
	public static int removeElement2(int[] arr, int val) {
		int j = arr.length;
		int i = 0;
		while(i<j) {
			if(arr[i]==val) {
				arr[i] = arr[j-1];
				j--;
			}else {
				i++;
			}
		}
		return j;
	}

}
