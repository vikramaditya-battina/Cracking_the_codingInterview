package LinkedList;

import java.util.HashSet;

public class RemoveDups {
	static class Node{
		int data;
		Node next;
		public Node(int val) {
			this.data = val;
			this.next = null;
		}
		
	}
	public static void main(String args[]) {
		int arr[] = new int[] {1,1,2,2,3,3,4,5,6,7,8,4,5,9};
		Node head = createLinkedList(arr);
		printLinkedList(head);
		removeDupsWithBuffer(head);
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
	
	public static void removeDupsWithBuffer(Node head) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(head.data);
		for(Node temp=head;temp.next !=null; ) {
			int val = temp.next.data;
			if(!set.contains(val)) {
				set.add(val);
				temp = temp.next;
			}else {
				temp.next = temp.next.next;
			}
		}
	}
	
	public static void removeDupsWithoutBuffer(Node head) {
		Node finalHead = head;
		for(Node temp = head; temp.next != null; temp = temp.next) {
			int val = head.next.data;
			for(Node temp2 = head; temp2 != temp.next; temp2 = temp2.next) {
				int val2 = temp2.next.data;
				
				if(val2 == val) {
					finalHead = head;
					temp2.next = temp2.next.next;
					break;
				}
			}
			
		}
	}
	
}
