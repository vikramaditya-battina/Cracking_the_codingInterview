package LinkedList;

import LinkedList.RemoveDups.Node;

public class ReturnKthtoLast {
	
	static class Node{
		int data;
		Node next;
		public Node(int val) {
			this.data = val;
			this.next = null;
		}
	}
	
	public static void main(String args[]) {
		int arr[] = new int[] {1,2};
		Node head = createLinkedList(arr);
		printLinkedList(head);
		head = removeKthFromLast(head, 2);
		printLinkedList(head);
	}
	
	public static void printLinkedList(Node head) {
		for(Node temp=head; temp != null; temp = temp.next) {
			System.out.print(temp.data+"->");
		}
		System.out.println();
	}
	
	public static Node createLinkedList(int arr[]) {
		Node head = new Node(0);
		Node temp = head;
		for(int i = 0 ; i < arr.length; i++) {
			temp.next = new Node(arr[i]);
			temp = temp.next;
		}
		return head.next;
	}
	
	public static Node removeKthFromLast(Node head, int k) {
		Node tempHead = new Node(0);
		tempHead.next = head;
		Node temp = tempHead;
		for(int i = 0 ; i < k ; i++) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		Node temp2,temp3;
		for(temp2=temp, temp3 = tempHead ; temp2.next != null; temp2=temp2.next,temp3=temp3.next);
		temp3.next = temp3.next.next;
		return tempHead.next;
	}
}
