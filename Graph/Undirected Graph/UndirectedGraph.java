import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    
    /******************* Printing Graph ********************/
		for(int i = 0 ; i < v ; i++) {
			System.out.print(i + " - ");
			for(int j: graph.A[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
