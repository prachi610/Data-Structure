package DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraphBFS {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices: ");
		int V = sc.nextInt();
		System.out.println("Enter number of edges: ");
		int E = sc.nextInt();
		System.out.println("Enter " + E + " edges");
		
		
		ArrayList<Integer>[] adj = new ArrayList[V];
		for(int i = 0 ; i < V ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		boolean ans = true;
		
		int[] color = new int[V];
		Arrays.fill(color, -1);
		
		for(int i = 0 ; i < V ; i++) {
			if(color[i] == -1) {
				if(!bfs(adj, color, i)) {
					ans = false;
					break;
				}
			}
		}
		if(ans) {
			System.out.println("Graph is Bipartite");
		}
		else
			System.out.println("Graph is not Bipartite");
	
	}

	private static boolean bfs(ArrayList<Integer>[] adj, int[] color, int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		color[i] = 0;
		while(!q.isEmpty()) {
			int val = q.poll();
			for(int neighbour : adj[val]) {
				if(color[neighbour] == -1) {
					color[neighbour] = 1-color[val];
					q.add(neighbour);
				}
				else if(color[neighbour] == color[val]) {
					return false;
				}
			}
		}
		return true;
	}

}
