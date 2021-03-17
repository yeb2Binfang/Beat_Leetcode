package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCNo210 {
	
	List<List<Integer>> edges;
	
	int[] visited;
	
	int[] result;
	
	boolean valid = true;
	
	int index;
	
	public int[] findOrder(int numCourse, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for(int i=0;i<numCourse;i++) {
			edges.add(new ArrayList<Integer>());
		}
		
		visited = new int[numCourse];
		result = new int[numCourse];
		index = numCourse-1;
		
		for(int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}
		
		for(int i=0;i<numCourse && valid;i++) {
			if(visited[i]==0) {
				dfs(i);
			}
		}
		
		if(!valid) {
			return new int[0];
		}
		
		return result;
	}
	
	public void dfs(int u) {
		visited[u] =1;
		for(int v : edges.get(u)) {
			if(visited[v]==0) {
				dfs(v);
				if(!valid) {
					return;
				}
			}else if(visited[v]==1) {
				valid = false;
				return;
			}
		}
		
		visited[u] =2;
		result[index--] =u;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCNo210 courseScheduleII = new LCNo210();
		int[][] prerequisites= {};
		int numCourse =1;
		System.out.println(Arrays.toString(courseScheduleII.findOrder(numCourse, prerequisites)));

	}

}
