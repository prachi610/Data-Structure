import java.util.Scanner;

public class DoublyLinkedList {
	
	class Node{
		int data;
		Node pre;
		Node next;
		Node(int data){
			this.data = data;
			pre = null;
			next = null;
		}
	}
	
	Node head;
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.creatDLL(5);
//		dll.print();
//		dll.insertAtEnd(7);
//		dll.print();
//		dll.insertAtFirst(5);
//		dll.print();
//		dll.insertAtKthPosition(3 , 10);
//		dll.print();
//		dll.deleteAtFirst();
//		dll.print();
//		dll.deleteAtLast();
//		dll.print();
//		dll.deleteAtKthPosition(2);
//		dll.print();
	}
	
	
	public void deleteAtKthPosition(int k) {
		Node temp = head;
		if(k == 1) {
			deleteAtFirst();
			return;
		}
		for(int i = 1 ; i < k-1 ; i++) {
			temp = temp.next;
		}
		Node store = temp;
		temp.next = temp.next.next;
		temp.pre = store;
	}


	public void deleteAtLast() {
		Node temp = head;
		if(head == null) {
			System.out.println("List was already empty.");
			return;
		}
		if(head.next == null) {
			head = null;
			System.out.println("List becomes empty.");
			return;
		}
		while(temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
//		System.out.println("Last element deleted");
	}


	public void deleteAtFirst() {
		Node temp = head;
		if(head == null) {
			System.out.println("List was already empty.");
			return;
		}
		if(temp.next == null) {
			head = null;
			System.out.println("List becomes empty.");
			return;
		}
		head = temp.next;
		temp.pre = null;
	}


	public void insertAtKthPosition(int k, int a) {
		Node temp = head;
		Node newnode = new Node(a);
		for(int i = 1 ; i < k-1 ; i++) {
			temp = temp.next;
		}
		Node store = temp.next;
		temp.next = newnode;
		newnode.pre = temp;
		newnode.next = store;
	}


	public void insertAtFirst(int a) {
		Node newnode = new Node(a);
		newnode.next = head;
		newnode.pre = null;
		head = newnode;
	}


	public void insertAtEnd(int a) {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		Node newnode = new Node(a);
		temp.next = newnode;
		newnode.pre = temp;
	}


	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}


	public void creatDLL(int n) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < n ; i++) {
			Node temp = head;
			int val = sc.nextInt();
			Node newnode = new Node(val);
			if(i == 0) {
				
				head = newnode;
				newnode.pre = null;
				newnode.next = null;
			}
			else {
				while(temp.next != null) {
					temp = temp.next;
				}
				temp.next = newnode;
				newnode.pre = temp;
			}
		}
		
	}

}
