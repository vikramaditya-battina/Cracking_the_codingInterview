package LinkedList;

import LinkedList.RemoveDups.Node;

public class DeleteMiddle {
	public static void main(String args[]) {
		int arr[] = new int[] {1,2,3,4,5};
		Node head = createLinkedList(arr);
		printLinkedList(head);
		head = deleteMiddle(head);
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
	
	public static Node deleteMiddle(Node head) {
		Node slowpointer = head;
		Node fastpointer = head;
		Node prevpointer = head;
		while(fastpointer != null && fastpointer.next != null && fastpointer.next.next != null) {
		    fastpointer = fastpointer.next.next;
		    prevpointer = slowpointer;
		    slowpointer = slowpointer.next;
		}
		if(prevpointer == head) {
			head = head.next;
			return head;
		}
		prevpointer.next = prevpointer.next.next;
		return head;
	}
}
