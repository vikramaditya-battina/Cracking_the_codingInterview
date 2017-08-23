package LinkedList;

import LinkedList.Partition.Node;

public class SumLists_Reverse {
	public static void main(String args[]) {
		int arr1[] = new int[]{7,1,6};
		Node head1 = createLinkedList(arr1);
		
		int arr2[] = new int[]{5,9,2};
		Node head2 = createLinkedList(arr2);
		
		Node head = sumList(head1, head2);
		printList(head);
	}
	
	public static Node createLinkedList(int arr[]) {
		Node dHead = new Node(0);
		Node iHead = dHead;
		for(int i = 0 ; i < arr.length; i++) {
			iHead.next = new Node(arr[i]);
			iHead = iHead.next;
		}
		return dHead.next;
	}
	
	public static void printList(Node head) {
		for(Node iHead= head; iHead != null; iHead = iHead.next) {
			System.out.print(iHead.data+" ");
		}
		System.out.println();
	}
	
	public static Node sumList(Node head1, Node head2) {
		int carry = 0;
		Node dHead = new Node(0);
		Node iHead = dHead;
		while(head1 != null && head2 != null) {
			int val = head1.data + head2.data + carry;
			carry = val/10;
			val = val%10;
			iHead.next = new Node(val);
			iHead = iHead.next;
			head1 = head1.next;
			head2 = head2.next;
		}
		while(head1 != null) {
			int val = head1.data + carry;
			carry = val/10;
			val = val%10;
			iHead.next = new Node(val);
			iHead = iHead.next;
			head1 = head1.next;
		}
		
		while(head2 != null) {
			int val = head2.data + carry;
			carry = val/10;
			val = val%10;
			iHead.next = new Node(val);
			iHead = iHead.next;
			head2 = head2.next;
		}
		if(carry != 0 ) {
			iHead.next = new Node(carry);
		}
		return dHead.next;
	}
}
