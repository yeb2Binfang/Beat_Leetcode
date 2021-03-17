package leetcodeMedium;

import java.util.Arrays;
import java.util.Comparator;

public class LCNo354 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] envelopes = {{2,3},{5,4},{6,4},{6,7}};
		System.out.println(RussianDollEnvelopes(envelopes));
		System.out.println(RussianDollEnvelopesBinary(envelopes));
		
//		Arrays.sort(envelopes, new Comparator<int[]>() {
//            public int compare(int[] arr1, int[] arr2) {
//                if (arr1[0] == arr2[0]) {
//                   	return arr2[1] - arr1[1];
//                    //return arr1[1] - arr2[1];	
//                } else {
//                    return arr1[0] - arr2[0];
//                }
//           }
//        });
//		
//		System.out.println(Arrays.deepToString(envelopes));

	}
	
	public static int RussianDollEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		int[] f = new int[n];
		
		Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
           }
        });


		int res = 0;
		for(int i=0;i<n;i++) {
			f[i] = 1;
			for(int j=0;j<i;j++) {
				if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1]>envelopes[j][1]) {
					f[i] = Math.max(f[i], f[j]+1);
				}
			}
			res = Math.max(res, f[i]);
		}
		return res;
	}
	
	public static int RussianDollEnvelopesBinary(int[][] envelopes) {
		int n = envelopes.length;
		int[] f = new int[n];
		
		Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
           }
        });
		
		for(int i=0;i<n;i++){
			f[i] = envelopes[i][1];
		}
		int len = LongestOfSub(f);
		return len;
		
	}
	
	public static int LongestOfSub(int[] arr) {
		int m = arr.length;
		int[] f = new int[m];
		int len = 0;
		for(int num : arr) {
			int i = Arrays.binarySearch(f, 0, len, num);
			if(i<0) {
				i=-(i+1);
			}
			f[i]=num;
			if(i==len) {
				len++;
			}
		}
		return len;
	}

}
