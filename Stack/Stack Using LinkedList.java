public class Stack_using_linkedList {
	
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data= data;		
		}
	}
	Node top;
	
	public static void main(String[] args) {
		
		Stack_using_linkedList s = new Stack_using_linkedList();
//		s.push(4);
//		s.push(5);
//		s.printStack();
//		s.pop();
//		s.printStack();
//		s.push(10);
//		int t = s.peek();
//		s.printStack();
//		System.out.println(t);
//		s.pop();
//		boolean b = s.isEmpty();
//		System.out.println(b);
//		s.printStack();
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		Node temp = top;
		while(temp != null) {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void push(int d) {
		Node newnode = new Node(d);
		if(top == null) {
			top = newnode;
			newnode.next = null;
			return;
		}
		newnode.next = top;
		top = newnode;
	}
	
	public void pop() {
		if(top == null) {
			System.out.println("Stack is empty");
			return;
		}
		
		top = top.next;
	}
	
	public int peek() {
		if(top == null) {
			System.out.println("Stack is empty");
			return -1;
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		return false;
	}
}
