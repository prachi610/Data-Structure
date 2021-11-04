package DataStructure;

import java.util.LinkedList;
import java.util.Scanner;

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
	}

}
