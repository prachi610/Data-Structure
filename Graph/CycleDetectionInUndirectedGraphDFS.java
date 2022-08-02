
import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetectionInUndirectedGraphDFS {

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
		
		boolean ans = false;
		
		boolean[] vis = new boolean[V];
		for(int i = 0 ; i < V ; i++) {
			if(!vis[i]) {
				if(isCycle(adj, vis, i, -1)){
					ans = true;
					break;
				}
			}
		}
		if(ans) {
			System.out.println("Graph contains cycle");
		}
		else
			System.out.println("Graph does not contains cycle");
	}

	private static boolean isCycle(ArrayList<Integer>[] adj, boolean[] vis, int i, int par) {
		vis[i] = true;
		for(int neighbour : adj[i]) {
			if(!vis[neighbour]) {
				if(isCycle(adj, vis, neighbour, i)){
					return true;
				}
			}
			else if(neighbour != par) {
				return true;
			}
		}
		return false;
	}

}
