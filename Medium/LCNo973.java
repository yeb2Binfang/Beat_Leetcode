package leetcodeMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LCNo973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points= new int[][] {{3,3},{5,-1},{-2,4}};
		int K = 2;
		int[][] res = kClosest(points, K);
		for(int[] row:res) {
			System.out.println(Arrays.toString(row));
		}
			
		//System.out.println(Arrays.toString(kClosest(points, K)));

	}
	
	public static int[][] kClosest(int[][] points, int K) {
		int[][] res = new int[K][2];
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[0]-o1[0];
			}

		});
		
		int row = points.length;
		for(int i=0;i<row;i++) {
			int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
			heap.offer(new int[] {dist,i});
			System.out.println(Arrays.toString(new int[] {dist,i}));
			if(heap.size()>K && dist<heap.peek()[0]) {
				heap.poll();
				//heap.offer(new int[] {dist,i});
			}
			
		}
		
		
		for(int i=0;i<K;i++) {
			res[i] = points[heap.poll()[1]];
		}
		return res;
    }

}
