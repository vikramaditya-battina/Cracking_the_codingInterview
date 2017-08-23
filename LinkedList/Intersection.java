package LinkedList;

public class Intersection {
	static class Node{
		int val;
		Node next;
		public Node() {
			
		}
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public static void main(String args[]) {
		int arr1[] = new int[]{1,2,3,4,5};
		int arr2[]  = new int[]{5,6,7};
		Node head1 = createList(arr2);
		Node head2 = createList(arr1);
		head2.next.next = head1.next.next;
		System.out.println(getIntersectionNode(head1, head2).val);
	}
	
	public static Node createList(int arr[]) {
		Node head = new Node(0);
		Node tempHead = head;
		for(int i = 0 ; i < arr.length; i++) {
			head.next = new Node(arr[i]);
			head = head.next;
		}
		return tempHead.next;
	}
	
	public static Node getIntersectionNode(Node head1, Node head2) {
		int len1 = length(head1);
		int len2 = length(head2);
		Node bigHead = null;
		if(len1 > len2){
			int diff = len1 - len2;
			while(diff != 0){
				head1 = head1.next;
				diff--;
			}
		}else{
			int diff = len2 - len1;
			while(diff != 0){
				head2 = head2.next;
				diff--;
			}
		}
		while(head1 != null && head2 != null){
			if(head1 == head2){
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}

	public static int length(Node head){
		int count = 0;
		while(head != null){
			count++;
			head = head.next;
		}
		return count;
	}
	
}
