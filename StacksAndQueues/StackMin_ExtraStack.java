package StacksAndQueues;

public class StackMin_ExtraStack<T extends Comparable<T>> {
	ListStack<T> mStack;
	ListStack<T> minStack;
	public StackMin_ExtraStack() {
		this.minStack = new ListStack<T>();
		this.mStack = new ListStack<T>();
	}
	public static void main(String args[]) {
		StackMin_ExtraStack<Integer> stack = new StackMin_ExtraStack<Integer>();
		stack.push(1);
		stack.push(3);
		System.out.println(stack.min());
		stack.pop();
		stack.push(5);
		stack.push(-2);
		stack.push(2);
		stack.push(-2);
		stack.push(-5);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		stack.pop();
		System.out.println(stack.min());
	}
	
	public void push(T t) {
		if(minStack.isEmpty()) {
			minStack.push(t);
			mStack.push(t);
			return;
		}
		T val = minStack.peek();
		if(val.compareTo(t)  >= 0) {
			minStack.push(t);
		}
		mStack.push(t);
	}
	
	public T pop() {
		T t = mStack.pop();
		if(minStack.peek().equals(t)) {
			minStack.pop();
		}
		return t;
	}
	
	public T min() {
		T t = minStack.peek();
		return t;
	}
}
