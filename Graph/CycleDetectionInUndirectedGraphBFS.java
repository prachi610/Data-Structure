
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair<T, U>{
    private T first;
    private U second;
    public Pair(T first, U second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return this.first;
    }
    public U getSecond(){
        return this.second;
    }
}
public class CycleDetectionInUndirectedGraphBFS {

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
				if(isCycle(adj, vis, i)){
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
	

	private static boolean isCycle(ArrayList<Integer>[] adj, boolean[] vis, int i) {
		
		Queue<Pair<Integer, Integer>> q = new LinkedList<>();
		q.add(new Pair<>(i, -1));
		vis[i] = true;
		while(!q.isEmpty()) {
			Integer val = q.peek().getFirst();
			Integer par = q.peek().getSecond();
			q.poll();
			for(int neighbour : adj[val]) {
				if(!vis[neighbour]) {
					q.add(new Pair<>(neighbour, val));
					vis[neighbour] = true;
				}
					
				else if(neighbour != par) {
					return true;
				}
			}
		}
		
		return false;
	}

}
