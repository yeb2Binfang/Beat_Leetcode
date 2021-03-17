package leetcodeMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LCNo378 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(kthSmallest2(matrix, 8));

	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int[] arr = new int[n*n];
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[count] = matrix[i][j];
				count++;
			}
		}
		Arrays.sort(arr);
		return arr[k-1];
    }
	
	public static int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
        	
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }


}
