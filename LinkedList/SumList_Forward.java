package LinkedList;

import LinkedList.Partition.Node;

public class SumList_Forward {
	public static void main(String args[]) {
		int arr1[] = new int[] {9,9,9};
		int arr2[] = new int[] {1,0,0};
		Node head1 = createList(arr1);
		Node head2 = createList(arr2);
		Node rHead = sumList(head1, head2);
		printList(rHead);
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
			System.out.print(iHead.data+", ");
		}
		System.out.println();
	}
	
	public static Node sumList(Node head1, Node head2) {
		Node dHead = new Node(0);
		int carry = 0;
		Node iHead = dHead;
		Node tail = dHead;
		while(head1!= null || head2 != null) {
			int val = 0;
			if(head1 != null) {
				val = head1.data;
				head1 = head1.next;
			}
			if(head2 != null) {
				val = val + head2.data;
				head2 = head2.next;
			}
			val += carry;
			carry = val/10;
			val = val%10;
			Node n = new Node(val);
			tail.next = n;
			tail = tail.next;
			if(val != 9) {
				while(iHead != n) {
					iHead.data = (iHead.data + carry)%10;
					iHead = iHead.next;
			    }
			}
			carry =0;
		}
		if(dHead.data == 1) {
			return dHead;
		}
		return dHead.next;
	}
}
