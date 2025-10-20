package list;

public class MyLinkedList {
	MyNode first;
	MyNode last;
	int size;
	
	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void addFirst(String s) { //O(1)
		MyNode newNode = new MyNode(s);
		if(isEmpty()) {
			last = newNode;
		}else {
			newNode.next = first;
		}
		first = newNode;
		size++;	
	}
	
	public void addLast(String s) { //O(1)
		MyNode newNode = new MyNode(s);
		if(isEmpty()) {
			first = newNode;
		}else {
			last.next = newNode;
		}
		last = newNode;
		size++;
	}
	
	public void removeFirst() {
		
	}
	
	public void removeLast() {
		
	}
			

	public void print(){
		MyNode pointer = first;
		if(!isEmpty()){
			System.out.print("| ");
			while(pointer!=null){
				System.out.print(pointer.element + " | ");
				pointer = pointer.next;
			}
			System.out.println();
		}
	}
}


class MyNode{
	String element;
	MyNode next;
	
	MyNode(String element){
		this.element = element;
	}
}
