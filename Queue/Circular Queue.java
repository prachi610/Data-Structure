public class CircularQueue {
	
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	Node front;
	Node rear;
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue();
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(98);
		queue.print();
		queue.deQueue();
		queue.deQueue();
		queue.print();
		int k = queue.nthElement(2);
		System.out.println(k);
		
	}
	
	public int nthElement(int n) {
		int count = 0;
		Node temp = front;
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		do {
			count++;
			temp = temp.next;
		}while(temp != front);
		
		if(n > count) {
			System.out.println("Overflow!");
			return -1;
		}
		Node tt = front;
		n--;
		while(n != 0) {
			tt = tt.next;
			n--;
		}
	    return tt.data;
	}

	public int deQueue() {
		if(isEmpty()) {
			System.out.println("Underflow!");
			return -1;
		}
		int k = front.data;
		front = front.next;
		rear.next = front;
		return k;
	}

	public void print() {
		if(front == null && rear == null) {
			System.out.println("Queue is empty.");
			return;
		}
		Node temp = front;
		do {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}while(temp != front); 
		System.out.println();
	}
	
	
	public void enQueue(int n) {
		Node newnode = new Node(n);
		if(isEmpty()) {
			rear = newnode;
			front = rear;
			rear.next = front;
			return;
		}
		rear.next = newnode;
		newnode.next = front;
		rear = newnode;
	}

	public boolean isEmpty() {
		if(front == null && rear == null) {
			return true;
		}
		return false;
	}
	

}
