

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UndirectedGraph {
	
	private LinkedList<Integer> A[];
	
	public UndirectedGraph(int v) {
		A = new LinkedList[v];
		for(int i = 0 ; i < v ; i++) {
			A[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int source, int dest) {
		A[source].add(dest);
		A[dest].add(source);
	}
	
	public void bfstry(int node, boolean[] visited) {
		int source = 0;
		visited[source] = true;

		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			System.out.print(cur + " ");
			for(int nieghbor : A[cur]) {
				
				if(!visited[nieghbor]) {
					visited[nieghbor] = true;
					q.add(nieghbor);
				}
				
			}
		}
	}
	
	
	public void bfs() {
		boolean[] vis = new boolean[A.length];
		for(int i = 0 ; i < A.length ; i++) {
			if(!vis[i]) {
				bfstry(i, vis);
			}
		}
	}
	

	/********************* DFS traversal *************************/
	public void dfs() {
		boolean[] visited = new boolean[A.length];
		for(int i = 0 ; i < A.length ; i++) {
			if(!visited[i]) {
				dfstry(i, visited);
			}
		}
	}
	
	private void dfstry(int i, boolean[] visited) {
		Stack<Integer> st = new Stack<>();
		st.add(i);
		visited[i] = true;
		while(!st.isEmpty()) {
			int store = st.pop();
			System.out.print(store + " ");
			for(int neighbor : A[store])
			if(!visited[neighbor]) {
				visited[neighbor] = true;
				st.add(neighbor);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		UndirectedGraph graph = new UndirectedGraph(v);
		System.out.println("Enter " + e + " edges");
		for(int i = 0 ; i < e ; i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			graph.addEdge(source, dest);
		}
		for(int i = 0 ; i < v ; i++) {
			System.out.print(i + " - ");
			for(int j: graph.A[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		graph.bfs();
		System.out.println();
		graph.dfs();
	}
}
