import java.util.Scanner;


public class CircularDoublyLinkedList {
	
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int data){
			this.data = data;
			next = null;
			prev = null;
		}
	}
	Node head;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularDoublyLinkedList cll = new CircularDoublyLinkedList();
		cll.creatLLofSizeN(3);
		cll.print();
//		cll.insertAtEnd(4);
//		cll.insertAtEnd(6);
//		cll.print();
//		cll.deleteLast();
//		cll.print();
//		cll.deleteFirst();
//		cll.print();
//		cll.insertAtKthPosition(2,10);
//		cll.print();
//		cll.insertAtFirst(4);
//		cll.print();
//		cll.deleteAtKthPosition(4);
//		cll.print();
		int value = cll.findKthElement(4);
		System.out.println(value);
		
	}
	public void creatLLofSizeN(int n) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < n ; i++) {
			int k = sc.nextInt();
			Node newnode = new Node(k);
			if(i == 0) {
				head = newnode; 		
				newnode.next = head;
				head.prev = newnode;				
			}
			else {
				Node temp = head;
				while(temp.next != head) {
					temp = temp.next;
				}
				temp.next = newnode;
				newnode.prev = temp;
				newnode.next = head;
			}
		}
	}
	
	/***********************Print the List*************************/
	public void print() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node temp = head;
		do {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}while(temp != head);	
		System.out.println();
	}

	/********************Add an element at the beginning of the LinkedList*********************/
	public void insertAtFirst(int a) {
		Node newnode = new Node(a);
		if(head == null) {
			head = newnode;
			newnode.next = head;
			head.prev = newnode;
			return;
		}
		Node temp = head;
		while(temp.next != head) {
			temp = temp.next;
		}
		temp.next = newnode;
		newnode.prev = temp;
		newnode.next = head;
		head = newnode;
		
	}
	
	
/**********************Add an element at the end of the LinkedList***********************/
	public void insertAtEnd(int a) {
		Node newnode = new Node(a);
		if(head == null) {
			head = newnode;
			newnode.next = head;
			head.prev = newnode;
			return;
		}
		else {
			Node temp = head;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = newnode;
			newnode.prev = temp;
			newnode.next = head;
		}
	}
	
	
/******************Add an element at Kth position of the LinkedList*********************/	
	public void insertAtKthPosition(int k,int d) {

		Node temp = head;
		Node newnode = new Node(d);
		if(k < 1) {
			System.out.println("Invalid input!");
			return;
		}
		if(k == 1) {
			insertAtFirst(d);
			return;
		}
		for(int i = 1 ; i < k-1 ; i++) {
			temp = temp.next;
		}
		Node store = temp.next;
		temp.next = newnode;
		newnode.prev = temp;
		newnode.next = store;
	}
	
	
/*********************Delete the first element of the List***********************/
	public void deleteFirst() {
		if(head == null) {
			System.out.println("Underflow");
			return;
		}
		if(head.next == head) {
			head = null;
			return;
		}
		Node temp = head;
		while(temp.next != head) {
			temp = temp.next;
		}
		temp.next = head.next;
		head = head.next;
		head.prev = temp;

	}
	
	
/*********************Delete the last element of the List***********************/
	public void deleteLast() {
		Node temp = head;
		if(head == null) {
			System.out.println("Underflow");
			return;
		}
		if(head.next == head) {
			head = null;
			return;
		}
		while(temp.next.next != head) {
			temp = temp.next;
		}
		temp.next = head;
		head.prev = temp;
	}
	
	
/*********************Delete the element present at Kth position***********************/
	public void deleteAtKthPosition(int k) {
		int count=1;
		Node v = head;
		int length = 0;
		do {
			length++;
			v = v.next;
		}while(v != head);
		
		if(k > length) {
			System.out.println("Position should be less than or equal to length of list.");
			return;
		}
		Node temp = head;
		if(k < 1) {
			System.out.println("Underflow");
			return;
		}
		if(k == 1) {
			deleteFirst();
			return;
		}
		else {
			while(count+1 < k) {
				temp = temp.next;
				count++;
			}
			Node after = temp.next.next;
			temp.next = after;
			after.prev = temp;
		}
	}

	
/*********************Find an element at Kth position***********************/
	public int findKthElement(int k) {
		Node temp = head;
		int count = 1;
		Node v = head;
		int length = 0;
		do {
			length++;
			v = v.next;
		}while(v != head);
		
		if(k > length) {
			System.out.println("Position should be less than or equal to length of list.");
			return -1;
		}
		while(count != k) {
			temp = temp.next;
			count++;
		}
		return temp.data;
	}

}
