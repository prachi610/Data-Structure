public class SimpleQueue {
	
	int front = -1, rear = -1;
	int size = 10;
	int[] A = new int[size];
	
	public static void main(String[] args) {
		SimpleQueue queue = new SimpleQueue();
//		queue.enQueue(5);
//		queue.enQueue(6);
//		queue.enQueue(98);
//		queue.enQueue(3);
//		queue.print();
//		queue.deQueue();
//		queue.print();
	}
	
	public void print() {
		if(front == -1) {
			System.out.println("Queue is empty.");
			return;
		}
		for(int i = front ; i <= rear && i != -1 ; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	public void enQueue(int n) {
		if(isFull()) {
			System.out.println("Overflow!");
			return;
		}
		if(front == -1) {
			front++; rear++;
		}
		else {
			rear++;
		}
		A[rear] = n;
		return;
	}
	
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("Underflow!");
			return -1;
		}
		int k = A[front];
		if(front >= rear) {
			front = -1;
			rear = -1;
		}
		else {
			front++;
		}
		return k;
	}
	
	public boolean isFull() {
		if(front == 0 && rear == size-1) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

}
