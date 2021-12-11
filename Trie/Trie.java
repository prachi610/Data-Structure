package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Trie {
	
	class Node{
		
		public char c;
		public boolean isWord;
		public Node[] children;
		
		public Node(char c) {
			this.c = c;
			isWord = false;
			children = new Node[26];
		}
	}
	
	Node head = new Node('\0');
	public void insert(String word) {
		Node temp = head;
		int n = word.length();
		for(int i = 0 ; i < n ; i++) {
			char ch = word.charAt(i);
			if(temp.children[ch - 'a'] == null) {
				temp.children[ch-'a'] = new Node(ch);
			}
			temp = temp.children[ch-'a'];
		}
		temp.isWord = true;
		
	}
	/****************************Check the given String is present in Trie or not**************************/
	public boolean isPresent(String word) {
		Node temp = head;
		int n = word.length();
		for(int i = 0 ; i < n ; i++) {
			char ch = word.charAt(i);
			if(temp.children[ch-'a'] == null) {
				return false;
			}
			temp = temp.children[ch-'a'];
		}
		if(temp != null && temp.isWord == true) {
			return true;
		}
		
		return false;
	}
	
//	public ArrayList<String> startWith(String s){
//		Node temp = head;
//		int n = s.length();
//		for(int i = 0 ; i < n ; i++) {
//			char ch = s.charAt(i);
//			if(temp.children[ch-'a'] == null) {
//				return new ArrayList<String>();
//			}
//			temp = temp.children[ch-'a'];
//		}
//		ArrayList<String> A = new ArrayList<>();
//		if(temp != null && temp.isWord == true) {
//			A.add(s);
//		}
//		
//		for(int i = 0 ; i < 26 ; i++) {
//			Node curr = temp;
//			StringBuilder ans = new StringBuilder(s);
//			if(curr.children[i] != null) {
//				do {
//					
//				} while (curr.isWord == false);
//			}
//		}
//		
//	}
  
  
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] A = new String[5];
		for(int i = 0 ; i < 5 ; i++) {
			A[i] = sc.next();
		}
		Trie t = new Trie();
		
		for(int i = 0 ; i < 5 ; i++) {
			t.insert(A[i]);
		}	
		System.out.println(t.isPresent("hell"));
	}

}


