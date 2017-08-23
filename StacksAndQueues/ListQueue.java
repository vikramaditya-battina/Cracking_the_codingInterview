package StacksAndQueues;

public class ListQueue<T> {
	private class Node{
		T data;
		Node next;
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	private Node head;
	private Node tail;
	public ListQueue() {
		this.head = null;
		this.tail = null;
	}
	
	public void Enqueue(T t) {
		if(this.tail == null) {
			this.tail = new Node(t);
			this.head = this.tail;
			return;
		}
		this.tail.next = new Node(t);
		this.tail = this.tail.next;
	}
	
	public T dequeue() {
		if(this.tail == null) {
			return null;
		}
		T t = this.head.data;
		this.head = this.head.next;
		if(this.head == null) {
			this.tail = null;
		}
		return t;
	}
	
	public boolean isEmpty() {
		if(this.tail == null) {
			return true;
		}
		return false;
	}
	
	public T peek() {
		if(this.tail == null) {
			return null;
		}
		return this.head.data;
	}
}
