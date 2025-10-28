package list;

public class MyLinkedList {
	MyNode first;
	MyNode last;
	int size;

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		//return this.size == 0;
		return first == null; 
	}

	public String getFirstElement() {
		if(!isEmpty())
			return first.element;
		return null;
	}

	public String getLastElement() {
		if(!isEmpty())
			return last.element;
		return null;
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

	public void removeFirst() { //O(1)
		if(!isEmpty()) {
			String temp = first.element;
			if(first == last) { //only one element in this list
				first = last = null;
			}else {
				first = first.next;
			}
			size--;
			System.out.println(temp + " is removed!");
		}else {
			System.out.println("List is Empty!");
		}
	}

	public void removeLast() { //O(n)
		if(!isEmpty()) {
			String temp = last.element;
			if(first == last) { //only one element in this list
				first = last = null;
			}else {
				MyNode prev = first;
				while(prev.next != last) {
					prev = prev.next;
				}
				prev.next = null;
				last = prev;
			}
			size--;
			System.out.println(temp + " is removed!");
		}else {
			System.out.println("List is Empty!");
		}
	}

	public void remove(String key) { //O(n)
		if(search(key)) {
			MyNode curr = first;
			MyNode prev = first;
			while(curr!=null && !curr.element.equals(key)) {
				prev = curr;
				curr = curr.next;
			}
			if(curr == first) removeFirst();
			else if (curr == last) removeLast();
			else {
				prev.next = curr.next;
				size--;
				System.out.println(key + " is removed!");
			}
		}else {
			System.out.println(key + " is not in the list!");
		}

	}

	public boolean search(String key) { //O(n)
		MyNode pointer = first;
		while(pointer!=null && !pointer.element.equals(key)) {
			pointer = pointer.next;
		}
		return pointer!=null;
	}

	public int find(String key) { //O(n) linear search
		int counter = -1;
		if(search(key)) {
			counter++;
			MyNode pointer = first;
			while(pointer!=null && !pointer.element.equals(key)) {
				counter++;
				pointer = pointer.next;
			}
		}
		return counter;
	}

	public String getElement(int index) { //O(n)
		if(index >= 0 && index < size) {
			if(index == 0) return getFirstElement();
			else if(index == size - 1) return getLastElement();
			else {
				int counter = 0;
				MyNode pointer = first;
				while(counter != index) {
					counter++;
					pointer = pointer.next;
				}
				return pointer.element;
			}
		}else {
			return null;
		}
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
