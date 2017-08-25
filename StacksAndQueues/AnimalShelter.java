package StacksAndQueues;

public class AnimalShelter{
	public static void main(String args[]) {
		AnimalShelter aS = new AnimalShelter();
		Animal animal1_c = new Animal("animal1_c","cat");
		Animal animal2_c = new Animal("animal2_c","cat");
		Animal animal3_c = new Animal("animal3_c","cat");
		Animal animal1_d = new Animal("animal1_d","dog");
		Animal animal2_d = new Animal("animal2_d","dog");
		Animal animal3_d = new Animal("animal3_d","dog");

		aS.addAnimal(animal1_c);
		aS.addAnimal(animal1_d);
		aS.addAnimal(animal2_c);
		aS.addAnimal(animal2_d);
		aS.addAnimal(animal3_d);
		aS.addAnimal(animal3_c);
		aS.printDList(aS.head, aS.tail);
		aS.printList(aS.dogHead);
		aS.printList(aS.catHead);
		assert aS.getAnimal().equals("animal1_c");
		assert aS.getDog().equals("animal1_d");
		assert aS.getAnimal().equals("animal2_c");
		assert aS.getCat().equals("animal3_c");
		assert aS.getDog().equals("animal2_d");
		assert aS.getAnimal().equals("animal3_d");
		assert aS.getAnimal() == null;
		assert aS.getDog() == null;
		assert aS.getCat() == null;
		System.out.println("All test cases passed...");
	}
	static class Animal{
		String type;
		String name;
		Animal(String name, String type){
			this.name = name;
			this.type = type;
		}
	}

	class Node{
		Animal data;
		Node next;
		Node previous;
		Node sameNext;
		Node(Animal animal){
			this.data = animal;
			this.next = null;
			this.previous = null;
			this.sameNext = null;
		}
	}
    Node dogHead;
	Node dogTail;
	Node catHead;
	Node catTail;
	Node head;
	Node tail;
	public String getDog(){
		if(this.dogHead == null){
			return null;
		}
		removeNode(this.dogHead);
		Animal animal = this.dogHead.data;
		if(this.dogHead == this.dogTail){
			this.dogHead = null;
			this.dogTail = null;
		}else{
			this.dogHead = this.dogHead.sameNext;
		}
		return animal.name;
	}

	public String getCat(){
		if(this.catHead == null){
			return null;
		}
		removeNode(this.catHead);
		Animal animal = this.catHead.data;
		if(this.catHead == this.catTail){
			this.catHead = null;
			this.catTail = null;
		}else{
			this.catHead = this.catHead.sameNext;
		}
		return animal.name;
	}

	public String getAnimal(){
		if(this.head == null){
			return null;
		}
		if(this.head.data.type.equals("cat")){
			return getCat();
		}else{
			return getDog();
		}
	}

	public void addAnimal(Animal animal){
		Node node = new Node(animal);
		if(this.head == null){
			this.head = node;
			this.tail = this.head;
		}else{
			this.tail.next = node;
			node.previous = this.tail;
			this.tail = this.tail.next;
		}
		if(animal.type.equals("cat")){
			if(this.catHead == null){
				this.catHead = node;
				this.catTail = node;
			}else{
				this.catTail.sameNext = node;
				this.catTail = this.catTail.sameNext;
			}
		}else{
			if(this.dogHead == null){
				this.dogHead = node;
				this.dogTail = node;
			}else{
				this.dogTail.sameNext = node;
				this.dogTail = this.dogTail.sameNext;
			}
		}
	}

	public void removeNode(Node node){
		Node nextNode = node.next;
		Node previousNode = node.previous;
		if(nextNode != null){
			nextNode.previous = previousNode;
		}
		if(previousNode != null){
			previousNode.next = nextNode;
		}
		if(node == this.head){
			this.head = this.head.next;
		}
		if(node == this.tail){
			this.tail = this.tail.previous;
		}
	}
	
	void printDList(Node head, Node tail) {
		Node iHead = head;
		while(iHead != null) {
			System.out.print(iHead.data.name+", ");
			iHead = iHead.next;
		}
		System.out.println();
		Node iTail = tail;
		while(iTail != null) {
			System.out.print(iTail.data.name+", ");
			iTail = iTail.previous;
		}
		System.out.println("----------------------------");
	}
	
	void printList(Node head) {
		Node iHead = head;
		while(iHead != null){
			System.out.print(iHead.data.name);
			iHead = iHead.sameNext;
		}
		System.out.println("------------------------------");
	}
}