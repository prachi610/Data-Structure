package DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DirectedGraph {

	private LinkedList<Integer> A[];
	
	public DirectedGraph(int v){
		A = new LinkedList[v];
		for(int i = 0 ; i < v ; i++) {
			A[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int source, int destination) {
		A[source].add(destination);
	}
	
	
	/********************* DFS traversal *************************/
	

	public void bfs() {
		boolean[] visited = new boolean[A.length];
		for(int i = 0 ; i < A.length ; i++) {
			if(!visited[i]) {
				bfstry(i, visited);
			}
		}
	}
	
	private void bfstry(int node, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		visited[node] = true;
		q.add(node);
		while(!q.isEmpty()) {
			int store = q.poll();
			System.out.print(store + " ");
			for(int neighbor : A[store]) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					q.add(neighbor);
				}
				
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
		DirectedGraph graph = new DirectedGraph(v);
		for(int i = 0 ; i < e ; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			graph.addEdge(source, destination);
		}
		
		/************************* Printing Graph ***********************/
		for(int i = 0 ; i < v ; i++) {
			System.out.print(i + " - ");
			for(int j: graph.A[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		graph.bfs();
		System.out.println();
		graph.dfs();
	}

}
