package StacksAndQueues;

public class SortStack {
	
	public static void main(String args[]) {
		int arr[] = new int[] {5,3,4,2,1,9,0,8};
		ListStack<Integer> stack = new ListStack<Integer>();
		for(int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		SortStack sStack = new SortStack();
		sStack.sort(stack);
		printStack(stack);
	}
	public static void printStack(ListStack<Integer> stack){
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("--------------------------");
	}
	public void sort(ListStack<Integer> stack) {
		ListStack<Integer> stack2 = new ListStack<Integer>();
		while(!stack.isEmpty()){
			    Integer val = stack.pop();
					while(!(stack2.isEmpty() || stack2.peek() >= val)){
						Integer valstack2 = stack2.pop();
						stack.push(valstack2);
					}
					stack2.push(val);
				}
		while(!stack2.isEmpty()){
			stack.push(stack2.pop());
		}
	}
}
