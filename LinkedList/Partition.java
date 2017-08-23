package LinkedList;

public class Partition {
	static class Node{
		int data;
		Node next;
		Node(int val){
			data = val;
			next = null;
		}
	}
	public static void main(String args[]) {
		int arr[] = new int[] {8,5,8,5,10,2,1};
		Node head = createLinkedList(arr);
		printLinkedList(head);
		head = partition(head, 5);
		printLinkedList(head);
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
	
	public static void printLinkedList(Node head) {
		for(Node temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data+", ");
		}
		System.out.println();
	}
	
	public static Node partition(Node head, int pval) {
		Node otail = findTail(head);
		Node dHead = new Node(0);
		dHead.next = head;
		Node iHead = dHead;
		Node ctail = otail;
		while(iHead.next != otail) {
			if(iHead.next.data >= pval) {
				Node delNode = iHead.next;
				iHead.next = iHead.next.next;
				ctail.next = delNode;
				delNode.next = null;
				ctail = ctail.next;
			}else {
				iHead = iHead.next;
			}
		}
		return dHead.next;
	}
	
	public static Node findTail(Node head) {
		Node iHead;
		for(iHead = head; iHead.next != null; iHead = iHead.next);
		return iHead;
	}
}
