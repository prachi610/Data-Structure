import java.util.Scanner;

public class Stack_using_array {
	
    int top;
    Stack_using_array(){
    	top = -1;
    }
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] A = new int[n];
	
	public static void main(String[] args) {
		System.out.println("Enter size of stack");
		Stack_using_array s = new Stack_using_array();
//		
//		s.push();
//		s.display();
//		s.push();
//		s.display();
//		boolean k = s.isEmpty();
//		System.out.println(k);
//		s.pop();
//		s.display();
//		s.peek();
//		s.display();
		
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		int i = top;
		while(i >= 0) {
			System.out.print(A[i] + " ");
			i--;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		if(top < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(top >= n-1) {
			return true;
		}
		else {
			return false;
		}
	}

	public void push() {
		System.out.println("Enter the number");
		int k = sc.nextInt();
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		
		top++;
		A[top] = k;
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return;
		}
		top--;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is already empty");
			return -1;
		}
		return A[top];
	}
	

}
