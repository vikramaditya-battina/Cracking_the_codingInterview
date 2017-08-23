package LinkedList;

import LinkedList.LinkedListReverse_Recursion.Node;

public class LinkedListReverse_Iterative {
	static class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public static void main(String args[]) {
		int arr[] = new int[] {1};
		Node head = createList(arr);
		printList(head);
		head = reverseList(head);
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
	
	public static Node reverseList(Node head) {
		Node curNode = head;
		Node nextNode = curNode.next;
		while(nextNode != null) { 
			Node nextnextNode = nextNode.next;
			nextNode.next = curNode;
			curNode = nextNode;
			nextNode = nextnextNode;
		}
		head.next = null;
		return curNode;
	}
}
