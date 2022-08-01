package DataStructure;

class BinaryIndexedTree {
	
	int[] bit;
	int[] arr;
	
	/************Construction of Binary Indexed Tree*****************/
	public BinaryIndexedTree(int[] array) {
		int n = array.length;
		arr = new int[n];
		arr = array;
		bit = new int[arr.length+1];
		for(int i = 0 ; i < n ; i++) {
			addX(i, arr[i]);
		}
		
	}
	/************Sum of element from 1st index till nth index***************/
	public int sum(int n) {
		int sm = 0;
		for(int k = n+1 ; k > 0 ; k -= (k&(-k))) {
			sm += bit[k];
		}
		return sm;
	}
	
	/************Update the array by adding X at the given INDEX***************/
	public void addX(int index, int x) { 
		for(int i = index+1 ; i < bit.length ; i += (i&(-i))) {
			bit[i] += x;
		}
	}

}

public class BinaryIndexedTreeImpl{
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{1,3,5,2,4,7};
		
		BinaryIndexedTree bn = new BinaryIndexedTree(arr);
		
	}
	
}
