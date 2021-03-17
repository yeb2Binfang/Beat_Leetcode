package leetcodeEasy;

public class LCNo35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1};
		//System.out.println(SearchInsertPositionBruteForce(arr, 98));
		System.out.println(SearchInsertionPositionBinarySearch(arr, 0));
	}
	
	public static int SearchInsertPositionBruteForce(int[] arr, int target) {
		
		if(target<=arr[0]) {
			return 0;
		}
		if(target>arr[arr.length-1]) {
			return arr.length;
		}
		
		for(int i = 0;i<arr.length;i++) {
			if(target>arr[i]) {
				continue;
			}else {
				return i;
			}
		}
		return 0;
	}
	
	public static int SearchInsertionPositionBinarySearch(int[] arr, int target) {
		
		int left = 0;
		int right = arr.length-1;
		int result = 0;
		while(left<=right) {
			int mid = (left+right)/2;
			if(target == arr[mid]) {
				return mid;
			}
			if(target>arr[mid]) {
				
				left = mid+1;
				result = left;
			}else {
				result = right;
				right = mid-1;
				
			}
		}
		return result;
	}

}
