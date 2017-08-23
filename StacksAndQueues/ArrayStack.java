package StacksAndQueues;

import java.util.EmptyStackException;

public class ArrayStack<T>{
	private int size = 0;
	private Object stack[];
	private int index;
	public ArrayStack(int size){
		this.size = size;
		this.stack = new Object[size];
		this.index = -1;
	}

	public boolean isFull(){
		if(this.index == this.stack.length-1){
			return true;
		}
		return false;
	}

	public boolean isEmpty(){
		if(this.index == -1){
			return true;
		}
		return false;
	}

	public void push(T t){
		if(isFull()){
			throw new RuntimeException("stack full");
		}
		this.stack[this.index+1] = t;
		this.index++;
	}

	public T pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		T t = (T)(this.stack[this.index]);
		this.index--;
		return t;
	}

	public T peek(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		T t = (T)this.stack[this.index];
		return t;
	}
}