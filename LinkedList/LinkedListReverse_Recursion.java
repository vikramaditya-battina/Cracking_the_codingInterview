package LinkedList;

public class LinkedListReverse_Recursion {
	static class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	static class Result{
		Node head;
		Node tail;
		Result(Node head, Node tail){
			this.head = head;
			this.tail = tail;
		}
	}
	public static void main(String args[]) {
		int arr[] = new int[] {1};
		Node head = createList(arr);
		printList(head);
		Result result = reverseList(head);
		printList(result.head);
	}
	
	public static Node createList(int arr[]) {
		Node dHead = new Node(0);
		Node iHead = dHead;
		for(int i = 0 ; i < arr.length; i++) {
			iHead.next = new Node(arr[i]);
			iHead = iHead.next;
		}
		return dHead.next;
	}
	
	public static void printList(Node head) {
		for(Node iHead = head; iHead != null; iHead = iHead.next) {
			System.out.print(iHead.val+" ");
		}
		System.out.println();
	}
	public static Result reverseList(Node head) {
		if(head.next == null) {
			return new Result(head, head);
		}
		Node curNode = head;
		Node nextNode = head.next;
		curNode.next = null;
		Result result = reverseList(nextNode);
		result.tail.next = curNode;
		result.tail = result.tail.next;
		return result;
	}
}
