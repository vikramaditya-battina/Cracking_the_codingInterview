package StacksAndQueues;

public class ListStackTest {
	public static void main(String args[]) {
		ListStack<Integer> stack = new ListStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		
		/*
		 * false
		 * 3
		 * 2
		 * 2
		 * 4
		 * false
		 * 1
		 * true
		 */
	}
}
