package StacksAndQueues;

import java.util.EmptyStackException;

public class ListStack<A>{
	private class StackNode<T>{
		T data;
		StackNode next;
		public StackNode(T data){
			this.next = null;
			this.data = data;
		}
	}
  private StackNode<A> head;
	public ListStack(){
		this.head = null;
	}

	public void push(A a){
		if(this.head == null){
			this.head = new StackNode<A>(a);
			return;
		}
		StackNode<A> temp = this.head;
		this.head = new StackNode<A>(a);
		this.head.next = temp;
	}

	public A pop(){
		if(this.head == null){
			 throw new EmptyStackException();
		}
		StackNode<A> tempHead = this.head;
		this.head = this.head.next;
		return tempHead.data;
	}

	public A peek(){
		if(this.head == null){
			throw new EmptyStackException();
		}
		return this.head.data;
	}

	public boolean isEmpty(){
		if(this.head == null){
			return true;
		}
		return false;
	}
}
