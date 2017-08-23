package LinkedList;

import LinkedList.LinkedListReverse_Iterative.Node;

public class PalindromList {
	static class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	static class Result{
		Node node;
		public Result(Node node) {
			this.node = node;
		}
	}
	public static void main(String args[]) {
		int arr[] = new int[] {1,2,5,5,2,1};
		Node head = createList(arr);
		printList(head);
		System.out.println(isPalindrome(head));
		printList(head);
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
	
	public static boolean isPalindrome(Node head) {
		return isPalindromRecursion(head, new Result(head), length(head));
	}
	public static boolean isPalindromRecursion(Node head, Result result, int len) {
		
		if(len == 2) {
			if(head.val == head.next.val) {
				return true;
			}
			return false;
		}else if(len == 1 || len == 0) {
			result.node = result.node.next;
			return true;
		}
		result.node = result.node.next;
		boolean r = isPalindromRecursion(head.next, result,len-2);
		if(r == false) {
			return false;
		}
		if(head.val == result.node.val) {
			result.node = result.node.next;
			return true;
		}
		return false;
	}
	
	public static int length(Node head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
