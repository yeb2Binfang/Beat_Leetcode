package leetcodeMedium;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LCNo207 {
	
	List<List<Integer>> edges;
	int[] visited;
	int[] indeg;
	boolean valid = true;
	
	public boolean canFinish(int numCourse, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for(int i=0;i<numCourse;i++) {
			edges.add(new ArrayList<Integer>());
		}
		visited = new int[numCourse];
		for(int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
			System.out.println("edges.get info[1]: "+edges.get(info[1]));
			System.out.println("info[0] is "+info[0]);
		}
		for(int i=0;i<numCourse&&valid;i++) {
			if(visited[i]==0) {
				dfs(i);
			}
		}
		return valid;
	}
	
	public void dfs(int u) {
		visited[u] = 1;
		for(int v:edges.get(u)) {
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
	}
	
	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for(int i=0;i<numCourses;i++) {
			edges.add(new ArrayList<Integer>());
		}
		indeg = new int[numCourses];
		for(int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
			++indeg[info[0]];
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<numCourses;i++) {
			if(indeg[i]==0) {
				queue.offer(i);
			}
		}
		
		int visited=0;
		while(!queue.isEmpty()) {
			++visited;
			int u = queue.poll();
			for(int v : edges.get(u)) {
				--indeg[v];
				if(indeg[v]==0) {
					queue.offer(v);
				}
			}
		}
		return visited == numCourses;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prerequisites = {{1,0},{1,2},{2,1}};
		LCNo207 courseSchedule = new LCNo207();
		//System.out.println(courseSchedule.canFinish(5, prerequisites));
		System.out.println(courseSchedule.canFinishBFS(3, prerequisites));
		
//		int[][] test = {{1,0},{2,3},{4,5},{6,7},{8,9}};
//		//System.out.println(Arrays.toString(test[0]));
//		for(int[] info : test) {
//			System.out.println(info[1]);
//		}
	}

}
